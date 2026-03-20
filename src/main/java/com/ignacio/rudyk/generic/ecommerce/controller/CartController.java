package com.ignacio.rudyk.generic.ecommerce.controller;

import com.ignacio.rudyk.generic.ecommerce.dto.CartDTO;
import com.ignacio.rudyk.generic.ecommerce.dto.response.ResponseDTO;
import com.ignacio.rudyk.generic.ecommerce.service.ICartService;
import com.ignacio.rudyk.generic.ecommerce.util.HttpUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private ICartService cartService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseDTO> getCart(HttpServletRequest httpServletRequest, @PathVariable Long userId) {
        LOGGER.info("Llamado al servicio /get-cart - id: {}", userId);
        return HttpUtil.isSucceful2xxResponse(httpServletRequest, cartService.getCart(userId));
    }

    @PostMapping("/{cartId}/{productId}")
    public ResponseEntity<ResponseDTO> addProduct(HttpServletRequest httpServletRequest, @PathVariable Long cartId, @PathVariable Long productId) {
        LOGGER.info("Llamado al servicio /add-product - cartId: {} - productId: {}", cartId, productId);
        cartService.addProduct(cartId, productId);
        return HttpUtil.isSucceful2xxResponse(httpServletRequest, null);
    }

    @DeleteMapping("/{cartId}/{productId}")
    public ResponseEntity<ResponseDTO> deleteProduct(HttpServletRequest httpServletRequest, @PathVariable Long cartId, @PathVariable Long productId) {
        LOGGER.info("Llamado al servicio /delete-product - cartId: {} - productId: {}", cartId, productId);
        cartService.deleteProduct(cartId, productId);
        return HttpUtil.isSucceful2xxResponse(httpServletRequest, null);
    }

}