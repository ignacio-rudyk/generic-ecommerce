package com.ignacio.rudyk.generic.ecommerce.mapper;

import com.ignacio.rudyk.generic.ecommerce.dto.CartDTO;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICartMapper {

    CartDTO toDTO(Cart cart);

}
