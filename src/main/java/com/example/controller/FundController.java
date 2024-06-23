package com.example.controller;

import com.example.dto.fundRq;
import com.example.dto.fundRs;
import com.example.service.FundService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@Api
@Slf4j
public class FundController {
    @Autowired
    private FundService fundService;

    private RestTemplate restTemplate;

    @PostMapping("/fetch-fund-data")
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

//        return jsonResponse;
        return fundRs;

    }

}
