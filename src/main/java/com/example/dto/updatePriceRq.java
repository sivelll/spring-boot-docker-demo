package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "updatePriceRq")
public class updatePriceRq {

    @JsonProperty("price")
    @Schema(description = "price", example = "20.67", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal price;
}
