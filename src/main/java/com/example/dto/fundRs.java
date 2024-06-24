package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Data
@Schema(description = "fundRs")
public class fundRs {
    @JsonProperty("statusCode")
    @Schema(description = "statusCode")
    private int statusCode;
    @Schema(description = "Message")
    @JsonProperty("Message")
    private String Message;
    @JsonProperty("Data")
    @Schema(description = "List<dataItem> Data")
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