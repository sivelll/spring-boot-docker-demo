package com.example.controller;

import com.example.service.FundService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Api
public class FundController {
    @Autowired
    private FundService fundService;

    private RestTemplate restTemplate;

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

    @PostMapping("/fetch-fund-data2")
    public ResponseEntity<String> fetchFundData2() {

        final String apiUrl = "https://www.cathaybk.com.tw/cathaybk/service/newwealth/fund/chartservice.asmx/GetFundNavChart";
        String requestBody = "{\"req\":{\"Keys\":[\"10480016\"],\"From\":\"2023/03/10\",\"To\":\"2024/03/\"}}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // 發送POST請求並取得回應
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());


    }
}
