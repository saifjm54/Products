package com.example.product.controller;

import com.example.product.dto.ProductRequest;
import com.example.product.model.Product;
import com.example.product.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts()
    {
        return productService.getAllProducts();
    }
    @GetMapping("{productId}")
    public Product getProduct(@PathVariable("productId") Integer productId){
        return productService.getProduct(productId);
    }
    /*@PostMapping
    public ResponseEntity<Product> addProduct(
            @RequestBody ProductRequest request
            ){
        productService.addProduct(request);
    }*/





}
