package com.megait.shoppingmall.repository;

import com.megait.shoppingmall.Entity.Product;

import java.util.List;

public interface ProductRepository {
    public Product save(Product product);
    public List<Product> getAllItems();
    public Product getItemById(Long id);
}
