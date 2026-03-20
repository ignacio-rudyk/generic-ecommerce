package com.ignacio.rudyk.generic.ecommerce.service.implementation;

import com.ignacio.rudyk.generic.ecommerce.dto.CartDTO;
import com.ignacio.rudyk.generic.ecommerce.dto.ProductDTO;
import com.ignacio.rudyk.generic.ecommerce.exception.BadRequestException;
import com.ignacio.rudyk.generic.ecommerce.exception.DataNotFoundException;
import com.ignacio.rudyk.generic.ecommerce.mapper.ICartMapper;
import com.ignacio.rudyk.generic.ecommerce.mapper.IProductMapper;
import com.ignacio.rudyk.generic.ecommerce.repository.ICartProductRepository;
import com.ignacio.rudyk.generic.ecommerce.repository.ICartRepository;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.Cart;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.CartProduct;
import com.ignacio.rudyk.generic.ecommerce.service.ICartService;
import com.ignacio.rudyk.generic.ecommerce.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    private IProductService productService;

    private ICartRepository cartRepository;

    private ICartProductRepository cartProductRepository;

    private ICartMapper cartMapper;

    private IProductMapper productMapper;

    public CartService(IProductService productService,
                       ICartRepository cartRepository,
                       ICartProductRepository cartProductRepository,
                       ICartMapper cartMapper,
                       IProductMapper productMapper) {
        this.productService = productService;
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
        this.cartMapper = cartMapper;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public void createCart(Long userId) {
        Cart cart = new Cart(userId);
        cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Long cartId) {
        if(cartId != null) {
            Optional<Cart> opCart = cartRepository.findById(cartId);
            if(opCart.isPresent()) {
                cartRepository.delete(opCart.get());
            } else {
                throw new DataNotFoundException("Carro no encontrado");
            }
        } else {
            throw new BadRequestException("El ID es null");
        }
    }

    @Override
    public CartDTO getCart(Long userId) {
        CartDTO cartDTO = cartMapper.toDTO(getEmptyCartByUserId(userId));
        if(cartDTO != null)
            return cartDTO.withProducts(findProductsFromCart(cartDTO.id()));
        throw new DataNotFoundException("Carro no encontrado");
    }

    @Override
    public void addProduct(Long cartId, Long productId) {
        CartProduct cartProduct = getCartProductByCartIdAndProductId(cartId, productId);
        if(cartProduct == null)
            cartProduct = new CartProduct(cartId, productId, 1L);
        else
            cartProduct.setQuantity(cartProduct.getQuantity() + 1L);

        cartProductRepository.save(cartProduct);
    }

    @Override
    public void deleteProduct(Long cartId, Long productId) {
        CartProduct cartProduct = getCartProductByCartIdAndProductId(cartId, productId);
        if(cartProduct == null) {
            throw new DataNotFoundException("El producto no se encuentra en el carrito");
        } else if(cartProduct.getQuantity() <= 1L) {
            cartProductRepository.delete(cartProduct);
        } else {
            cartProduct.setQuantity(cartProduct.getQuantity() - 1L);
            cartProductRepository.save(cartProduct);
        }
    }

    private Cart getEmptyCartByUserId(Long userId) {
        if(userId == null)
            throw new BadRequestException("El ID es null");
        Optional<Cart> opCart = cartRepository.findByUserId(userId);
        return opCart.orElse(null);
    }

    private List<ProductDTO> findProductsFromCart(Long cartId) {
        return productService.findProductsByCartId(cartId).stream()
                .map(p -> productMapper.toDTO(p))
                .toList();
    }

    private CartProduct getCartProductByCartIdAndProductId(Long cartId, Long productId) {
        if(cartId != null && productId != null) {
            Optional<CartProduct> opCartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId);
            return opCartProduct.orElse(null);
        } else {
            throw new BadRequestException("Los IDs son nulos");
        }
    }

}