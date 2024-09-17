package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product=productRepository.findByName("product4");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod(){
        Product product=productRepository.findById(1L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> product=productRepository.findByNameOrDescription("product4","product5 description");
        product.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameAndDescriptionMethod(){
        List<Product> product=productRepository.findByNameAndDescription("product4","product5 description");
        product.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findDistinctMethod(){
        Product product=productRepository.findDistinctByName("product4");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product> products=productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product> products=productRepository.findByPriceLessThan(new BigDecimal(300));
        products.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameContainingMethod(){
        List<Product> products=productRepository.findByNameContaining("produ");
        products.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameLikeMethod(){
        List<Product> products=productRepository.findByNameLike("product4");
        products.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> products=productRepository.findByPriceBetween(new BigDecimal(100),new BigDecimal(300));
        products.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod(){

        LocalDateTime startDate=LocalDateTime.of(2024,9,17,22,12,0);
        LocalDateTime endDate=LocalDateTime.of(2024,9,17,23,12,0);
        List<Product> products=productRepository.findByDateCreatedBetween( startDate,endDate);
        products.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameInMethod(){
        List<Product> products=productRepository.findByNameIn(List.of("product4","product5"));
        products.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> products=productRepository.findFirst2ByOrderByNameAsc();
        products.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findTopByOrderByPriceDescMethod(){
        List<Product> products=productRepository.findTopByOrderByPriceDesc();
        products.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }





}
