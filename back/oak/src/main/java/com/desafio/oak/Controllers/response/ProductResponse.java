package com.desafio.oak.Controllers.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private String name;
    private Double value;
}
