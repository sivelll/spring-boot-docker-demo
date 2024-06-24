package com.example.controller;

import com.example.dto.*;
import com.example.service.FundService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="fund controller")
@Slf4j
public class FundController {
    @Autowired
    private FundService fundService;

    @PostMapping("/fetch-fund-data")
    @Operation(summary = "利用POST方法獲取資料", description = "利用POST方法獲取資料，並將data存於price、product兩張table。")
//    public ResponseEntity<String> fetchFundData(@RequestBody fundRq param) throws Exception {
    public fundRs fetchFundData(@RequestBody fundRq param) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInputString = objectMapper.writeValueAsString(param);
        log.info(jsonInputString);
        // 发送POST请求
        String targetUrl = "https://www.cathaybk.com.tw/cathaybk/service/newwealth/fund/chartservice.asmx/GetFundNavChart";
        ResponseEntity<String> jsonResponse = fundService.sendPostRequest(targetUrl, jsonInputString);

        fundRs fundRs = objectMapper.readValue(jsonResponse.getBody(), fundRs.class);
        // 输出服务器响应结果
        log.info(jsonResponse.getBody());
        log.info(fundRs.toString());
        fundService.saveProduct(fundRs.getData());
        fundService.savePrice(fundRs.getData());

//        return jsonResponse;
        return fundRs;

    }

    @GetMapping("/get_price")
    @Operation(summary = "利用GET方法獲取資料", description = "利用GET方法獲取單筆price資料")
    public priceRs get_price(@Parameter(description = "date", example = "2023/03/10") @RequestParam String date) throws Exception {
        log.info(date);
        return fundService.getPrice(date);
    }

    @PutMapping("/update_price")
    @Operation(summary = "利用PUT方法更新資料", description = "利用PUT方法更新單筆price資料")
    public priceRs update_price(@Parameter(description = "date", example = "2023/03/10") @RequestParam String date,@RequestBody updatePriceRq param) throws Exception {
        return fundService.update_price(date,param);
    }

    @PostMapping("/add_price")
    @Operation(summary = "利用POST方法新增資料", description = "利用POST方法新增單筆price資料")
    public priceRs add_price(@RequestBody priceRq param) throws Exception {
        return fundService.add_price(param);
    }

    @DeleteMapping("/delete_price")
    @Operation(summary = "利用DELETE方法刪除資料", description = "利用DELETE方法刪除單筆price資料")
    public priceRs delete_price(@Parameter(description = "date", example = "2023/03/10") @RequestParam String date) throws Exception {
        log.info(date);
        return fundService.delete_price(date);
    }

}
