package com.desafio.oak.Controllers.mappers;

import com.desafio.oak.Controllers.response.ProductResponse;
import com.desafio.oak.models.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static List<ProductResponse> mapToProductResponse(List<ProductModel> productModelList){
        List<ProductResponse> productResponseList = new ArrayList<>();

        for(ProductModel productModel : productModelList){
            productResponseList.add(ProductResponse.builder()
                            .name(productModel.getName())
                            .value(productModel.getPrice())
                            .build());
        }

        return productResponseList;
    }
}
