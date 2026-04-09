package com.ignacio.rudyk.generic.ecommerce.service;

import com.ignacio.rudyk.generic.ecommerce.repository.entity.PaymentMethod;

public interface IPaymentMethodService {

    PaymentMethod findById(Long id);

}