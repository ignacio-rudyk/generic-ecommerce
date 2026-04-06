package com.ignacio.rudyk.generic.ecommerce.dto;

import java.math.BigDecimal;

public record OrderItemDTO(Long id,
                           Long ProductId,
                           String productTitle,
                           BigDecimal unitPrice,
                           BigDecimal Subtotal,
                           Long quantity) {
}