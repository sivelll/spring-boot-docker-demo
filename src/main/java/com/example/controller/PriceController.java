package com.example.controller;

import com.example.dto.CalculationResult;
import com.example.service.ClosingPriceCalculator;
import com.example.service.PercentageChangeCalculator;
import com.example.service.PreviousClosingPriceCalculator;
import com.example.service.PriceChangeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
    @Autowired
    private PriceChangeCalculator priceChangeCalculator;

    @Autowired
    private ClosingPriceCalculator closingPriceCalculator;

    @Autowired
    private PreviousClosingPriceCalculator previousClosingPriceCalculator;

    @Autowired
    private PercentageChangeCalculator percentageChangeCalculator;

    @GetMapping("/price_change")
    public CalculationResult getPriceChange(@RequestParam String startDate, @RequestParam String endDate) throws Exception {
        return priceChangeCalculator.calculate(startDate, endDate);
    }

    @GetMapping("/closing_price")
    public CalculationResult getClosingPrice(@RequestParam String startDate, @RequestParam String endDate) throws Exception {
        return closingPriceCalculator.calculate(startDate, endDate);
    }

    @GetMapping("/previous_closing_price")
    public CalculationResult getPreviousClosingPrice(@RequestParam String startDate, @RequestParam String endDate) throws Exception {
        return previousClosingPriceCalculator.calculate(startDate, endDate);
    }

    @GetMapping("/percentage_change")
    public CalculationResult getPercentageChange(@RequestParam String startDate, @RequestParam String endDate) throws Exception {
        return percentageChangeCalculator.calculate(startDate, endDate);
    }
}