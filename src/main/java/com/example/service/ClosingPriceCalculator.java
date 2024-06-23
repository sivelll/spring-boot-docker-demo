package com.example.service;

import com.example.dto.CalculationResult;
import com.example.entity.price;
import com.example.repository.PriceRepository;
import com.example.service.serviceImpl.PriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClosingPriceCalculator implements PriceCalculator {
    @Autowired
    private PriceRepository priceRepository;

    @Override
    public CalculationResult calculate(String startDate, String endDate) throws Exception {
        price endPrice = priceRepository.findByDate(endDate);

        if (endPrice == null) {
            throw new Exception("Price data not found for the given date");
        }

        CalculationResult result = new CalculationResult();
        result.setClosingPrice(endPrice.getPrice());
        return result;
    }
}
