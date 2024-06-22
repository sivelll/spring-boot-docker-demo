package com.example.controller;

import com.example.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundController {
    @Autowired
    private FundService fundService;

    @GetMapping("/fetch-fund-data")
    public String fetchFundData() {
        try {
            fundService.fetchAndStoreFundData();
            return "Data fetched and stored successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching data!";
        }
    }
}
