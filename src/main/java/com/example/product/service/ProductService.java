package com.example.product.service;

import com.example.product.dto.ProductDTO;
import com.example.product.dto.ProductRequest;
import com.example.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<ProductDTO> getAllProducts();
    public Optional<ProductDTO> getProduct(Integer productId);
    public void addProduct(ProductRequest product);
    public void deleteProduct(Integer productId);
    public void checkIfProductExistsOrThrow(Integer productId);
    public void updateProduct(Integer productId,ProductRequest product);


}
