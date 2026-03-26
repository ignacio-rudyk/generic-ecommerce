package com.ignacio.rudyk.generic.ecommerce.repository;

import com.ignacio.rudyk.generic.ecommerce.repository.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileRepository extends JpaRepository<File, Long> {
}
