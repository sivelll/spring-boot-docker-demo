package com.example.service;

import com.example.entity.price;
import com.example.entity.product;
import com.example.repository.PriceRepository;
import com.example.repository.ProductRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class FundService {
    private static final String API_URL = "https://www.cathaybk.com.tw/cathaybk/service/newwealth/fund/chartservice.asmx/GetFundNavChart";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceRepository priceRepository;

    public void fetchAndStoreFundData() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"req\":{\"Keys\":[\"10480016\"],\"From\":\"2023/03/10\",\"To\":\"2024/03/\"}}";
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);
        log.info(response.getBody());
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode root = mapper.readTree(response.getBody());
//        JsonNode productNode = root.path("product");
//        JsonNode priceNode = root.path("price");
//
//        // Assuming the structure of JSON and parsing accordingly
//        String productId = productNode.path("id").asText();
//        String productName = productNode.path("name").asText();
//        String productShortName = productNode.path("shortName").asText();
//        boolean isGrouped = productNode.path("isGrouped").asBoolean();
//
//        product product = new product();
//        product.setProductId(productId);
//        product.setProductName(productName);
//        product.setProductShortName(productShortName);
//        product.setGrouped(isGrouped);
//        productRepository.save(product);
//
//        for (JsonNode priceData : priceNode) {
//            price price = new price();
//            price.setProductId(productId);
//            price.setDate(priceData.path("date").asText());
//            price.setPrice(priceData.path("value").asDouble());
//            priceRepository.save(price);
//        }
//    }
    }
}