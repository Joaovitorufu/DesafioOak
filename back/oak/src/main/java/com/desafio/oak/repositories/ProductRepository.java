package com.desafio.oak.repositories;

import com.desafio.oak.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

    @Query("SELECT p FROM ProductModel p ORDER BY p.price ASC")
    List<ProductModel> findAllOrderByPriceAsc();
}
