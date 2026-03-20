package com.ignacio.rudyk.generic.ecommerce.repository;

import com.ignacio.rudyk.generic.ecommerce.repository.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICartProductRepository extends JpaRepository<CartProduct, Long> {

    Optional<CartProduct> findByCartIdAndProductId(Long cartId, Long productId);

}