package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class updatePriceRq {
    @JsonProperty("date")
    private String date;

    @JsonProperty("price")
    private BigDecimal price;
}