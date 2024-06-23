package com.example.service.serviceImpl;

import com.example.dto.CalculationResult;

public interface PriceCalculator  {
    CalculationResult calculate(String startDate, String endDate) throws Exception;
}
