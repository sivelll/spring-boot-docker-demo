package com.example.service;

import com.example.dto.CalculationResult;
import com.example.entity.price;
import com.example.repository.PriceRepository;
import com.example.service.serviceImpl.PriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PriceChangeCalculator implements PriceCalculator {
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

        CalculationResult result = new CalculationResult();
        result.setPriceChange(priceChange);
        return result;
    }
}
