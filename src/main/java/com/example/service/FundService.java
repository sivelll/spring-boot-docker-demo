package com.example.service;

import com.example.dto.fundRs;
import com.example.dto.priceRq;
import com.example.dto.priceRs;
import com.example.entity.price;
import com.example.entity.product;
import com.example.repository.PriceRepository;
import com.example.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
            productItem.setDataGrouping(dataGrouping ? "Y" : "N");
            log.info(productItem.toString());
            // 保存到数据库
            productRepository.save(productItem);
        }
    }

    public void savePrice(List<fundRs.dataItem> data) {
        List<Object> itemData = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        for (fundRs.dataItem item : data) {
            for (List<Object> sublist : item.getData()) {
//                itemData.add(sublist.get(0));
                price price = new price();
                Double doubleValue = (Double) sublist.get(0);
                Long timestamp = doubleValue.longValue();
                Instant instant = Instant.ofEpochMilli(timestamp);
                // 使用 LocalDateTime 和 DateTimeFormatter 格式化为字符串
                LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                String formattedDate = dateTime.format(formatter);
                itemData.add(formattedDate);
                itemData.add(item.getId());
                itemData.add(sublist.get(1));

                // save price
                price.setDate(formattedDate);
                price.setDataId(item.getId());
                price.setPrice(BigDecimal.valueOf((Double) sublist.get(1)));
                priceRepository.save(price);
            }
        }
        log.info(itemData.toString());
    }

    public priceRs getPrice(priceRq param) {
        priceRs priceRs = new priceRs();
        log.info(param.getDate());
        Optional<price> price = priceRepository.findById(param.getDate());
        log.info(price.toString());
        if (price.isPresent()) {
            priceRs.setDate(price.get().getDate());
            priceRs.setPrice(price.get().getPrice());
        }
        return priceRs;
    }
}
