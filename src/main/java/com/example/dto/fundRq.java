package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "fundRq")
public class fundRq {

    @JsonProperty("req")
    private Req req;

    public static class Req {
        @JsonProperty("keys")
        @Schema(description = "List of keys", example = "[\"10480016\"]", requiredMode = Schema.RequiredMode.REQUIRED)
        private List<String> Keys;
        @JsonProperty("From")
        @Schema(description = "From day", example = "2023/03/10", requiredMode = Schema.RequiredMode.REQUIRED)
        private String From;
        @JsonProperty("To")
        @Schema(description = "To day", example = "2024/03/10", requiredMode = Schema.RequiredMode.REQUIRED)
        private String To;

    }
}
