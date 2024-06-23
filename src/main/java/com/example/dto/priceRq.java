package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class priceRq {
    @JsonProperty("date")
    private String date;
}
