package com.ignacio.rudyk.generic.ecommerce.dto;

public record ProductDTO(Long id, String title, PriceDTO price, String description, String shortDescription, CategoryDTO category) {
}