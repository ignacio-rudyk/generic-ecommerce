package com.ignacio.rudyk.generic.ecommerce.repository;

import com.ignacio.rudyk.generic.ecommerce.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.userContact WHERE u.id = :id")
    Optional<User> findByIdWithUserContact(@Param("id") Long id);

}