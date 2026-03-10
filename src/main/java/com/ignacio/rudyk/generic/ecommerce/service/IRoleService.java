package com.ignacio.rudyk.generic.ecommerce.service;

import com.ignacio.rudyk.generic.ecommerce.repository.entities.Role;

public interface IRoleService {

    Role findByCode(String code);

}