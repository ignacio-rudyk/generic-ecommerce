package com.ignacio.rudyk.generic.ecommerce.service.implementation;

import com.ignacio.rudyk.generic.ecommerce.repository.IRoleRepository;
import com.ignacio.rudyk.generic.ecommerce.repository.entity.Role;
import com.ignacio.rudyk.generic.ecommerce.service.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

    private IRoleRepository roleRepository;

    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByCode(String code) {
        return roleRepository.findByCode(code);
    }

}