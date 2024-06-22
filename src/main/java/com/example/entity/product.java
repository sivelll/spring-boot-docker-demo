package com.example.entity;

import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@Data
public class product {
    @jakarta.persistence.Id
    private Long productId;
    private String productName;
    private String productShortName;
    private boolean isGrouped;

}