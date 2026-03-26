package com.ignacio.rudyk.generic.ecommerce.service;

import com.ignacio.rudyk.generic.ecommerce.dto.ProductDTO;
import com.ignacio.rudyk.generic.ecommerce.dto.ProductRequestDTO;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.Product;

import java.util.List;

public interface IProductService {

    void createProduct(ProductRequestDTO newProduct);

    ProductDTO findById(Long productId);

    void updateProduct(ProductRequestDTO updateProduct);

    void deleteProduct(Long productId);

    List<Product> findProductsByCartId(Long cartId);

}