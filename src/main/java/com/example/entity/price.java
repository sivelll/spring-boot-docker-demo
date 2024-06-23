package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class price {
    @jakarta.persistence.Id
    @Column(name = "date")
    private String date;
    @Column(name = "data_id")
    private String dataId;
    @Column(name = "price")
    private BigDecimal price;

}
