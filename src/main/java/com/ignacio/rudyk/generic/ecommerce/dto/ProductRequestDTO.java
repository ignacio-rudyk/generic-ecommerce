package com.ignacio.rudyk.generic.ecommerce.dto;

import java.math.BigDecimal;

public record ProductRequestDTO(Long id, String title, BigDecimal price, BigDecimal costPrice, String description, String shortDescription, Long categoryId, String base64Image, String urlImage) {
}