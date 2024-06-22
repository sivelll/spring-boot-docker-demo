package com.example.controller;

import com.example.service.FundService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class FundController {
    @Autowired
    private FundService fundService;

    @PostMapping("/fetch-fund-data")
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
