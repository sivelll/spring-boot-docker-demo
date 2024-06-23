package com.example.service;

import com.example.dto.CalculationResult;
import com.example.entity.price;
import com.example.repository.PriceRepository;
import com.example.service.serviceImpl.PriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PercentageChangeCalculator implements PriceCalculator {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public CalculationResult calculate(String startDate, String endDate) throws Exception {
        price startPrice = priceRepository.findByDate(startDate);
        price endPrice = priceRepository.findByDate(endDate);

        if (startPrice == null || endPrice == null) {
            throw new Exception("Price data not found for the given dates");
        }

        BigDecimal priceChange = endPrice.getPrice().subtract(startPrice.getPrice());
        BigDecimal percentageChange = priceChange.divide(startPrice.getPrice(), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100));

        CalculationResult result = new CalculationResult();
        result.setPercentageChange(percentageChange);
        return result;
    }
}
