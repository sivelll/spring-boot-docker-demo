package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class price {
    @jakarta.persistence.Id
    @Column(name = "date")
    private Date date;
    @Column(name = "data_id")
    private String dataId;
    @Column(name = "price")
    private BigDecimal price;

}
