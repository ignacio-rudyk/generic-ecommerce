package com.ignacio.rudyk.generic.ecommerce.dto;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record OrderDTO(Long id,
                       BigDecimal totalAmount,
                       OrderStateDTO orderState,
                       Date createdAt,
                       Date lastModification,
                       Long userId,
                       List<OrderItemDTO> items) {

    public OrderDTO withItems(List<OrderItemDTO> items) {
        return new OrderDTO(id, totalAmount, orderState, createdAt, lastModification, userId, items);
    }

}
