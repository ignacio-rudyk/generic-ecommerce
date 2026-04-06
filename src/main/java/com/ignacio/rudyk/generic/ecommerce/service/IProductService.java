package com.ignacio.rudyk.generic.ecommerce.service;

import com.ignacio.rudyk.generic.ecommerce.dto.ProductDTO;
import com.ignacio.rudyk.generic.ecommerce.dto.ProductRequestDTO;

import java.util.List;

public interface IProductService {

    void createProduct(ProductRequestDTO newProduct);

    ProductDTO findById(Long productId);

    void updateProduct(ProductRequestDTO updateProduct);

    void deleteProduct(Long productId);

}