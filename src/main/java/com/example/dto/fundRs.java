package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class fundRs {
    @JsonProperty("statusCode")
    private int statusCode;
    @JsonProperty("Message")
    private String Message;
    @JsonProperty("Data")
    private List<dataItem> Data;

    @Data
    public static class dataItem {
        @JsonProperty("name")
        private String name;
        @JsonProperty("shortName")
        private String shortName;
        @JsonProperty("id")
        private String id;
        @JsonProperty("dataGrouping")
        private boolean dataGrouping;
        @JsonProperty("data")
        private List<List<Object>> data;
    }
}