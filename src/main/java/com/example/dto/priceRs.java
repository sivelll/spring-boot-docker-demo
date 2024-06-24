package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "priceRs")
public class priceRs {
    @JsonProperty("date")
    @Schema(description = "date")
    private String date;

    @JsonProperty("price")
    @Schema(description = "price")
    private BigDecimal price;
}
