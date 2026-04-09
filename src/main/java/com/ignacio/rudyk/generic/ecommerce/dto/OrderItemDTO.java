package com.ignacio.rudyk.generic.ecommerce.dto;

import java.math.BigDecimal;

public record OrderItemDTO(Long id,
                           Long productId,
                           Long orderId,
                           String productTitle,
                           BigDecimal unitPrice,
                           BigDecimal subtotal,
                           Long quantity) {
}