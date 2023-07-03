package com.example.product.repository;

import com.example.product.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@Transactional
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
