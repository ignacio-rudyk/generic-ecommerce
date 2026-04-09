package com.ignacio.rudyk.generic.ecommerce.dto;

public record NewPaymentDTO(Long orderId, Long paymentMethodId, String currencyCode) {
}
