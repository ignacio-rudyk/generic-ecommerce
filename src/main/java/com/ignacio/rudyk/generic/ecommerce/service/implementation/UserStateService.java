package com.ignacio.rudyk.generic.ecommerce.service.implementation;

import com.ignacio.rudyk.generic.ecommerce.repository.IUserStateRepository;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.UserState;
import com.ignacio.rudyk.generic.ecommerce.service.IUserStateService;
import org.springframework.stereotype.Service;

@Service
public class UserStateService implements IUserStateService {

    private IUserStateRepository userStateRepository;

    public UserStateService(IUserStateRepository userStateRepository) {
        this.userStateRepository = userStateRepository;
    }

    @Override
    public UserState findByCode(String code) {
        return userStateRepository.findByCode(code);
    }

}