package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //create product
        Product product=new Product();
        product.setName("product1");
        product.setDescription("product1 description");
        product.setStockKeepingUnit("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        //save product
        Product savedObject= productRepository.save(product);

        //display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());


    }

    @Test
    void updateUsingSaveMethod(){
        //find  on entity by id
        Long id=1L;
        Product product=productRepository.findById(id).get();
        //update entity info
        product.setName("update product1");
        product.setDescription("updated product 1 desc");

        //save updated entity
        productRepository.save(product); // EntityManager merge() method

    }

    @Test
    void finByIdMethod(){
        Long id=1L;

        Product product=productRepository.findById(id).get();

    }

    @Test
    void saveAllMethod(){
        //create product
        Product product=new Product();
        product.setName("product4");
        product.setDescription("product4 description");
        product.setStockKeepingUnit("100ABCDF");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("product4.png");

        //create product
        Product product3=new Product();
        product3.setName("product5");
        product3.setDescription("product5 description");
        product3.setStockKeepingUnit("100ABCDEA");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product5.png");

        //save product

        productRepository.saveAll(List.of(product,product3));

    }

    @Test
    void findAllMethod(){
        List<Product> products=productRepository.findAll();

        products.forEach((p)->{
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod(){
        Long id=1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){
        //find an entity by id
        Long id=2L;
        Product product=productRepository.findById(id).get();

        //delete(entity)
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){
        //productRepository.deleteAll();

        Product product=productRepository.findById(8L).get();

        Product product1=productRepository.findById(9L).get();

        productRepository.deleteAll(List.of(product,product1));

    }

    @Test
    void countMethod(){
        long count=productRepository.count();
        System.out.println(count);
    }

    @Test
    void exitsById(){
        Long id=10L;

        boolean result=productRepository.existsById(id);

        System.out.println(result);
    }

}