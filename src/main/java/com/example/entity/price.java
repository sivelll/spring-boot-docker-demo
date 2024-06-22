package com.example.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class price {
    @jakarta.persistence.Id
    private Date date;
    private String dataId;
    private BigDecimal price;

}
