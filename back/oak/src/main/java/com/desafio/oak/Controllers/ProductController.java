package com.desafio.oak.Controllers;


import com.desafio.oak.dtos.ProductRecordDto;
import com.desafio.oak.models.ProductModel;
import com.desafio.oak.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> products = productService.findAllOrderByPriceAsc();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody ProductRecordDto productRecordDto) {

        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        productService.save(productModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(productModel);
    }
}