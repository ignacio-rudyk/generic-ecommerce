package com.ignacio.rudyk.generic.ecommerce.dto;

public record ProductDTO(String title, PriceDTO price, String description, String shortDescription, CategoryDTO category) {
}