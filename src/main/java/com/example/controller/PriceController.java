package com.example.controller;

import com.example.dto.CalculationResult;
import com.example.service.ClosingPriceCalculator;
import com.example.service.PercentageChangeCalculator;
import com.example.service.PreviousClosingPriceCalculator;
import com.example.service.PriceChangeCalculator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
@Tag(name="Calculator price controller")
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
    @Operation(summary = "利用GET方法，計算價格變化(漲跌)", description = "利用GET方法，計算價格變化(漲跌)")
    public CalculationResult getPriceChange(@Parameter(description = "startDate", example = "2023/03/13") @RequestParam String startDate, @Parameter(description = "endDate", example = "2023/03/14") @RequestParam String endDate) throws Exception {
        return priceChangeCalculator.calculate(startDate, endDate);
    }

    @GetMapping("/closing_price")
    @Operation(summary = "利用GET方法，得知收盤價(後收)", description = "利用GET方法，得知收盤價(後收)")
    public CalculationResult getClosingPrice(@Parameter(description = "startDate", example = "2023/03/13") @RequestParam String startDate, @Parameter(description = "endDate", example = "2023/03/14") @RequestParam String endDate) throws Exception {
        return closingPriceCalculator.calculate(startDate, endDate);
    }

    @GetMapping("/previous_closing_price")
    @Operation(summary = "利用GET方法，得知收盤價(前收)", description = "利用GET方法，得知收盤價(前收)")
    public CalculationResult getPreviousClosingPrice(@Parameter(description = "startDate", example = "2023/03/13") @RequestParam String startDate, @Parameter(description = "endDate", example = "2023/03/14") @RequestParam String endDate) throws Exception {
        return previousClosingPriceCalculator.calculate(startDate, endDate);
    }

    @GetMapping("/percentage_change")
    @Operation(summary = "利用GET方法，得知漲跌幅", description = "利用GET方法，得知漲跌幅")
    public CalculationResult getPercentageChange(@Parameter(description = "startDate", example = "2023/03/13") @RequestParam String startDate, @Parameter(description = "endDate", example = "2023/03/14") @RequestParam String endDate) throws Exception {
        return percentageChangeCalculator.calculate(startDate, endDate);
    }
}
