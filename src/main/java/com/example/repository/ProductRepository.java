package com.example.repository;

import com.example.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<product, String> {
}
