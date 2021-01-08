package com.megait.shoppingmall.repository;

import com.megait.shoppingmall.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private final EntityManager em;

    @Autowired
    public ProductRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public Product save(Product product){
        em.persist(product);
        return product;
    }

    public List<Product> getAllItems(){
        List<Product> resultList = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        return resultList;
    }

    public Product getItemById(Long id){
        Product product = em.find(Product.class, id);
        em.detach(product);
        return product;
    }

    public void sellItem(Product product){
        Product item = em.find(Product.class, product.getId());
        int stock = item.getStock() - product.getStock();
        System.out.println("=================================================");
        System.out.println("stock : " + item.getStock() + " " + product.getStock());
        item.setStock(stock);
    }
}
