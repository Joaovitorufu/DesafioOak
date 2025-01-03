package com.desafio.oak.services;

import com.desafio.oak.models.ProductModel;
import com.desafio.oak.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductModel save(ProductModel productModel) {
        productRepository.save(productModel);
        return productModel;
    }

    public List<ProductModel> findAllOrderByPriceAsc(){
        return productRepository.findAllOrderByPriceAsc();
    }
}
