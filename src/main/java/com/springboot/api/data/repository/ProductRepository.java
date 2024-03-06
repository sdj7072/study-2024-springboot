package com.springboot.api.data.repository;

import com.springboot.api.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product AS p WHERE p.name = ?1")
    List<Product> findByName(String name);

    @Query("SELECT p FROM Product AS p WHERE p.name = :name")
    List<Product> findByNameParam(@Param("name") String name);

    List<Product> findByName(String Name, Sort sort);

    Page<Product> findByName(String Name, Pageable pageable);
}
