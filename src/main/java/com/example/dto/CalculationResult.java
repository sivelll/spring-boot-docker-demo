package com.example.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CalculationResult {

    private BigDecimal closingPrice;
    private BigDecimal previousClosingPrice;
    private BigDecimal priceChange;
    private BigDecimal percentageChange;
}
