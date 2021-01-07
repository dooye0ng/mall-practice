package com.megait.shoppingmall.service;

import com.megait.shoppingmall.Entity.Product;
import com.megait.shoppingmall.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllItems();
    }
}