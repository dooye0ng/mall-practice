package com.megait.shoppingmall.config;

import com.megait.shoppingmall.repository.ProductRepository;
import com.megait.shoppingmall.repository.ProductRepositoryImpl;
import com.megait.shoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@ComponentScan
public class MallConfig {

    private EntityManager em;

    @Autowired
    public MallConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public ProductService productService(){
        return new ProductService(productRepository());
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepositoryImpl(em);
    }
}
