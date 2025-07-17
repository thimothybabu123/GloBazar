package com.app.globazaar.repository;

// make this into a product repository

import com.app.globazaar.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByName(String name);

}