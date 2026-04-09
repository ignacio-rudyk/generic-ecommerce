package com.ignacio.rudyk.generic.ecommerce.service.implementation;

import com.ignacio.rudyk.generic.ecommerce.repository.IPaymentStateRepository;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.PaymentState;
import com.ignacio.rudyk.generic.ecommerce.service.IPaymentStateService;
import org.springframework.stereotype.Service;

@Service
public class PaymentStateService implements IPaymentStateService {

    private IPaymentStateRepository paymentStateRepository;

    public PaymentStateService(IPaymentStateRepository paymentStateRepository) {
        this.paymentStateRepository = paymentStateRepository;
    }

    @Override
    public PaymentState findByCode(String code) {
        return paymentStateRepository.findByCode(code);
    }

}