package com.ignacio.rudyk.generic.ecommerce.service;

import com.ignacio.rudyk.generic.ecommerce.dto.CartProdutcDTO;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.OrderItem;

import java.util.List;

public interface IOrderItemService {

    List<OrderItem> saveItems(Long orderId, List<CartProdutcDTO> products);

}