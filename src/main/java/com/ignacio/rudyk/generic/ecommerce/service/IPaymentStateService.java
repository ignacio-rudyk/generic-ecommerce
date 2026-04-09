package com.ignacio.rudyk.generic.ecommerce.service;

import com.ignacio.rudyk.generic.ecommerce.repository.entity.PaymentState;

public interface IPaymentStateService {

    PaymentState findByCode(String code);

}