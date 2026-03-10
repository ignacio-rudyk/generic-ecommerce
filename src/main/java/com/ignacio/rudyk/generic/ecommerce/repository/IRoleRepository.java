package com.ignacio.rudyk.generic.ecommerce.repository;

import com.ignacio.rudyk.generic.ecommerce.repository.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    Role findByCode(String code);

}