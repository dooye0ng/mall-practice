package com.megait.shoppingmall.repository;

import com.megait.shoppingmall.entity.Product;

import java.util.List;

public interface ProductRepository {
    public Product save(Product product);
    public List<Product> getAllItems();
    public Product getItemById(Long id);
    public void sellItem(Product product);
}
