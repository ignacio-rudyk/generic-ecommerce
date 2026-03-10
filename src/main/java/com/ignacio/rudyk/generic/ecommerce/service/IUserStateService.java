package com.ignacio.rudyk.generic.ecommerce.service;

import com.ignacio.rudyk.generic.ecommerce.repository.entities.UserState;

public interface IUserStateService {

    UserState findByCode(String code);

}
