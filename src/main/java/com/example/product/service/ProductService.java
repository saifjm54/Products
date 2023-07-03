package com.example.product.service;

import com.example.product.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProduct(Integer productId);
    public void addProduct(Product product);
    public void deleteProduct(Integer productId);
    public void checkIfProductExistsOrThrow(Integer productId);
    public void updateProduct(Integer productId,Product product);


}
