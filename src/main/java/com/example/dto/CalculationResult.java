package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "CalculationResult")
public class CalculationResult {
    @JsonProperty("closingPrice")
    @Schema(description = "closingPrice")
    private BigDecimal closingPrice;
    @JsonProperty("previousClosingPrice")
    @Schema(description = "previousClosingPrice")
    private BigDecimal previousClosingPrice;
    @JsonProperty("priceChange")
    @Schema(description = "priceChange")
    private BigDecimal priceChange;
    @JsonProperty("percentageChange")
    @Schema(description = "percentageChange")
    private BigDecimal percentageChange;
}
