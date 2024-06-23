package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class priceRq {
    @JsonProperty("date")
    private String date;

    @JsonProperty("price")
    private BigDecimal price;

    @Column(name = "data_id")
    private String dataId;
}
