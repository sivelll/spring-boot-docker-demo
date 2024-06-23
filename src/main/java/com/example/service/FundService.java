package com.example.service;

import com.example.dto.fundRs;
import com.example.entity.product;
import com.example.repository.PriceRepository;
import com.example.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class FundService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceRepository priceRepository;

    public static ResponseEntity<String> sendPostRequest(String url, String requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }

    public void saveProduct(List<fundRs.dataItem> data) {
        // 处理每个 DataItem 对象
        for (fundRs.dataItem item : data) {
            // 可以进一步处理 item 的其他属性
//            System.out.println(item.getName());
//            System.out.println(item.getShortName());
//            System.out.println(item.getId());
//            System.out.println(item.isDataGrouping());
//            System.out.println("=====");
            String dataId = item.getId();
            String name = item.getName();
            String shortName = item.getShortName(); // 可能为 null
            boolean dataGrouping = item.isDataGrouping();

            product productItem = new product();
            productItem.setDataId(dataId);
            productItem.setName(name);
            productItem.setShortName(shortName);
            productItem.setDataGrouping(dataGrouping? "Y" : "N");
            log.info(productItem.toString());
            // 保存到数据库
            productRepository.save(productItem);
        }
    }
}
