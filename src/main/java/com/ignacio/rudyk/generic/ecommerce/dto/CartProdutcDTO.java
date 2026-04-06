package com.ignacio.rudyk.generic.ecommerce.dto;

public record CartProdutcDTO(Long id,
                             Long cartId,
                             ProductDTO product,
                             Long quantity) {
}
