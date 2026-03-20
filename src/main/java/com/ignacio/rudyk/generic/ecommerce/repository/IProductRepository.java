package com.ignacio.rudyk.generic.ecommerce.repository;

import com.ignacio.rudyk.generic.ecommerce.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p " +
            " LEFT JOIN CartProduct cp ON cp.productId = p.id " +
            " LEFT JOIN Cart c ON c.id = cp.cartId" +
            " WHERE c.id = :cartId ")
    List<Product> findProductsByCartId(@Param("cartId") Long cartId);

    Optional<Product> findById(Long productId);

}