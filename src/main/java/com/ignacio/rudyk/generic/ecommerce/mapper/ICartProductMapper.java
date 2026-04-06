package com.ignacio.rudyk.generic.ecommerce.mapper;

import com.ignacio.rudyk.generic.ecommerce.dto.CartProdutcDTO;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.CartProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICartProductMapper {

    CartProdutcDTO toDTO(CartProduct cartProduct);

}