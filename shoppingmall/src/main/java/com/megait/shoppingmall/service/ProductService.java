package com.megait.shoppingmall.service;

import com.megait.shoppingmall.entity.Product;
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

    public Product getProductById(Long id){
        return productRepository.getItemById(id);
    }
    public void sellProduct(Product product){
        productRepository.sellItem(product);
    }
}