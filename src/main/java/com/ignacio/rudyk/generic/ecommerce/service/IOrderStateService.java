package com.ignacio.rudyk.generic.ecommerce.service;

import com.ignacio.rudyk.generic.ecommerce.repository.entity.OrderState;

public interface IOrderStateService {

    OrderState findByCode(String code);

}