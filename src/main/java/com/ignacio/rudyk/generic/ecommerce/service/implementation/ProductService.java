package com.ignacio.rudyk.generic.ecommerce.service.implementation;

import com.ignacio.rudyk.generic.ecommerce.repository.IProductRepository;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.Product;
import com.ignacio.rudyk.generic.ecommerce.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findProductsByCartId(Long cartId) {
        return productRepository.findProductsByCartId(cartId);
    }

    @Override
    public Product findById(Long productId) {
        if(productId == null)
            return null;
        Optional<Product> opCart = productRepository.findById(productId);
        return opCart.orElse(null);
    }

    @Override
    public boolean existsById(Long productId) {
        return productRepository.existsById(productId);
    }

}