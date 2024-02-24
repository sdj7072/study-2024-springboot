package com.springboot.api.data.repository;

import com.springboot.api.data.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void selectTest() {
        // Given
        Product product = new Product();

        product.setName("펜");
        product.setPrice(1000);
        product.setStock(1000);

        Product savedProduct = productRepository.saveAndFlush(product);

        // When
        Product foundProduct = productRepository.findById(savedProduct.getNumber()).get();

        // Then
        Assertions.assertEquals(product.getName(), foundProduct.getName());
        Assertions.assertEquals(product.getPrice(), foundProduct.getPrice());
        Assertions.assertEquals(product.getStock(), foundProduct.getStock());
    }

    @Test
    void saveTest() {
        // Given
        Product product = new Product();

        product.setName("펜");
        product.setPrice(1000);
        product.setStock(1000);

        // When
        Product savedProduct = productRepository.save(product);

        // Then
        Assertions.assertEquals(product.getName(), savedProduct.getName());
        Assertions.assertEquals(product.getPrice(), savedProduct.getPrice());
        Assertions.assertEquals(product.getStock(), savedProduct.getStock());
    }
}
