package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "priceRq")
public class priceRq {
    @JsonProperty("date")
    @Schema(description = "date", example = "2023/03/13", requiredMode = Schema.RequiredMode.REQUIRED)
    private String date;

    @JsonProperty("price")
    @Schema(description = "price", example = "20.67", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal price;

    @JsonProperty("data_id")
    @Schema(description = "dataId", example = "10480016", requiredMode = Schema.RequiredMode.REQUIRED)
    private String dataId;
}
