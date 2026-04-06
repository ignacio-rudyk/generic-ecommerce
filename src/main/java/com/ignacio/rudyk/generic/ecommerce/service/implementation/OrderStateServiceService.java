package com.ignacio.rudyk.generic.ecommerce.service.implementation;

import com.ignacio.rudyk.generic.ecommerce.repository.IOrderStateRepository;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.OrderState;
import com.ignacio.rudyk.generic.ecommerce.service.IOrderStateService;
import org.springframework.stereotype.Service;

@Service
public class OrderStateServiceService implements IOrderStateService {

    private IOrderStateRepository orderStateRepository;

    public OrderStateServiceService(IOrderStateRepository orderStateRepository) {
        this.orderStateRepository = orderStateRepository;
    }

    @Override
    public OrderState findByCode(String code) {
        return orderStateRepository.findByCode(code);
    }

}
