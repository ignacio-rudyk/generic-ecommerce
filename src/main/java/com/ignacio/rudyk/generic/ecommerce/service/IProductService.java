package com.ignacio.rudyk.generic.ecommerce.service;

import com.ignacio.rudyk.generic.ecommerce.repository.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> findProductsByCartId(Long cartId);

    Product findById(Long productId);

    boolean existsById(Long productId);

}