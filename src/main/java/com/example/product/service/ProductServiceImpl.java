package com.example.product.service;

import com.example.product.dao.ProductDao;
import com.example.product.dto.ProductDTOMapper;
import com.example.product.dto.ProductRequest;
import com.example.product.exception.RequestException;
import com.example.product.exception.ResourceNotFoundException;
import com.example.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductDao repository;


    @Override
    public List<Product> getAllProducts() {
        return repository.selectAllProducts().stream().collect(Collectors.toList());
    }

    @Override
    public Product getProduct(Integer productId) {
        return repository.selectProductById(productId).orElseThrow(() -> new ResourceNotFoundException(
                "product with id [%s] not found".formatted(productId)
        ));
    }

    @Override
    public void addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setCode(productRequest.code());
        product.setName(productRequest.name());
        repository.insertProduct(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        checkIfProductExistsOrThrow(productId);
        repository.deleteProductById(productId);
    }

    @Override
    public void checkIfProductExistsOrThrow(Integer productId) {
          if(!repository.existsProductById(productId)){
              throw new ResourceNotFoundException("product with id [%s] not found".formatted(productId));
          }
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest update) {
        Product product = repository.selectProductById(productId).orElseThrow(() -> new ResourceNotFoundException("product with id [%s] not found".formatted(productId)));
        boolean changes = false;
        if (update.name() !=null && !update.name().equals(product.getName())){
            product.setName(update.name());
            changes = true;
        }
        if(update.code() != null && !update.code().equals(product.getCode())){
            product.setCode(update.code());
            changes = true;
        }
        if(!changes){
            throw new RequestException("no data changes found");
        }
        repository.updateProduct(product);
    }
}
