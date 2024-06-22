package com.example.repository;

import com.example.entity.price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<price, Long> {
}