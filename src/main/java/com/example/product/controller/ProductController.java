package com.example.product.controller;

import com.example.product.dto.ProductRequest;
import com.example.product.model.Product;
import com.example.product.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @PostMapping
    public ResponseEntity<Object> addProduct(
            @RequestBody ProductRequest request
            ){
        productService.addProduct(request);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("{productId}")
    public ResponseEntity<Object> deleteProduct(
            @PathVariable("productId") Integer productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product is deleted successfully",HttpStatus.NO_CONTENT);
    }
    @PutMapping("{productId}")
    public ResponseEntity<Object> updateProduct(
            @PathVariable("productId") Integer productId,
            @RequestBody ProductRequest productRequest){
        productService.updateProduct(productId,productRequest);
        return new ResponseEntity<>("Product is updated successsfully",HttpStatus.OK);
    }


}
