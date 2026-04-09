package com.ignacio.rudyk.generic.ecommerce.mapper;

import com.ignacio.rudyk.generic.ecommerce.dto.OrderItemDTO;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOrderItemMapper {

    OrderItemDTO toDTO(OrderItem orderItem);

}
