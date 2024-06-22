package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class fundRq {

    @JsonProperty("req")
    private Req req;

    public static class Req {
        @JsonProperty("keys")
//        @Schema(description = "List of keys", example = "[\"10480016\"]")
        private List<String> Keys;
        @JsonProperty("From")
//        @Schema(description = "From day", example = "2023/03/10")
        private String From = "2023/03/10";
        @JsonProperty("To")
//        @Schema(description = "To day", example = "2024/03/10")
        private String To = "2024/03/10";

    }
}
