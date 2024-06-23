package com.example.service;

import com.example.dto.fundRs;
import com.example.entity.price;
import com.example.entity.product;
import com.example.repository.PriceRepository;
import com.example.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
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
import java.util.Date;
import java.util.List;

import static org.hibernate.internal.util.BytesHelper.asLong;

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

//    public void savePriceFromList(List<Object> rowData) {
//        price price = new price();
//        price.setDate((String) rowData.get(0));
//        price.setDataId((String) rowData.get(1));
//        price.setPrice(BigDecimal.valueOf((Double) rowData.get(2)));
//
//        // 保存实体到数据库
//        priceRepository.save(price);
//    }

//    public void savePricesFromList(List<Object> rowDataList) {
//        for (Object rowData : rowDataList) {
//            price price = new price();
//            List<Object> rowDataItems = (List<Object>) rowData;
//
//            price.setDate((String) rowDataItems.get(0)); // 设置日期
//            price.setDataId((String) rowDataItems.get(1)); // 设置数据 ID
//            price.setPrice(BigDecimal.valueOf((Double) rowDataItems.get(2))); // 设置价格
//
//            // 保存实体到数据库
//            priceRepository.save(price);
//        }
//    }
}
