package com.ignacio.rudyk.generic.ecommerce.mapper;

import com.ignacio.rudyk.generic.ecommerce.dto.CategoryDTO;
import com.ignacio.rudyk.generic.ecommerce.dto.PriceDTO;
import com.ignacio.rudyk.generic.ecommerce.dto.ProductDTO;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.Category;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.Price;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    ProductDTO toDTO(Product product);

    PriceDTO toDTO(Price price);

    CategoryDTO toDTO(Category category);

}