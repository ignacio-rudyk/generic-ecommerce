package com.ignacio.rudyk.generic.ecommerce.dto;


import java.util.Date;
import java.util.List;

public record OrderDTO(Long id,
                       OrderStateDTO orderState,
                       Date createdAt,
                       Date lastModification,
                       Long cartId,
                       List<OrderItemDTO> items) {
}
