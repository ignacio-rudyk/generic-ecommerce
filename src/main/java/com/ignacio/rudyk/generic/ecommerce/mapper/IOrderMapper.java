package com.ignacio.rudyk.generic.ecommerce.mapper;

import com.ignacio.rudyk.generic.ecommerce.dto.OrderDTO;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOrderMapper {

    OrderDTO toDTO(Order order);

}