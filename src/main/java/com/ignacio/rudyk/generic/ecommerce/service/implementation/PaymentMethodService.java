package com.ignacio.rudyk.generic.ecommerce.service.implementation;

import com.ignacio.rudyk.generic.ecommerce.exception.DataNotFoundException;
import com.ignacio.rudyk.generic.ecommerce.repository.IPaymentMethodRepository;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.PaymentMethod;
import com.ignacio.rudyk.generic.ecommerce.service.IPaymentMethodService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentMethodService implements IPaymentMethodService {

    private IPaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(IPaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public PaymentMethod findById(Long id) {
        Optional<PaymentMethod> opPaymentMethod = paymentMethodRepository.findById(id);
        if(opPaymentMethod.isEmpty())
            throw new DataNotFoundException("No se encontro el metodo de pago");
        return paymentMethodRepository.findById(id).get();
    }

}
