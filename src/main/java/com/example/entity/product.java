package com.example.entity;

import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@Data
public class product {
    @jakarta.persistence.Id
    private Long dataId;
    private String name;
    private String shortName;
    private boolean dataGrouping;

}