package com.springboot.api.data.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.api.data.entity.Product;
import com.springboot.api.data.entity.QProduct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

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

    @Test
    void sortingAndPagingTest() {
        Product product1 = new Product();
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("펜");
        product2.setPrice(5000);
        product2.setStock(300);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("펜");
        product3.setPrice(500);
        product3.setStock(50);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        Product saveProduct1 = productRepository.save(product1);
        Product saveProduct2 = productRepository.save(product2);
        Product saveProduct3 = productRepository.save(product3);

        productRepository.findByName("펜", Sort.by(Sort.Order.asc("price")));
        productRepository.findByName("펜", getSort());

        productRepository.findByName("펜", PageRequest.of(0, 2));

    }

    private Sort getSort() {
        return Sort.by(
                Sort.Order.asc("price"),
                Sort.Order.desc("stock")
        );
    }

    @Test
    void queryDslTest() {
        JPAQuery<Product> query = new JPAQuery<>(entityManager);
        QProduct qProduct = QProduct.product;

        List<Product> productList = query
                .from(qProduct)
                .where(qProduct.name.eq(("펜")))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Product product : productList) {
            System.out.println("----------");
            System.out.println();
            System.out.println("Product Number : " + product.getNumber());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Product Price : " + product.getPrice());
            System.out.println("Product Stock : " + product.getStock());
            System.out.println();
            System.out.println("----------");
        }
    }

    @Test
    void queryDslJPAFactoryTest() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<String> productList = jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq(("펜")))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (String product : productList) {
            System.out.println("----------");
            System.out.println();
            System.out.println("Product Name : " + product);
            System.out.println();
            System.out.println("----------");
        }

        List<Tuple> tupleList = jpaQueryFactory
                .select(qProduct.name, qProduct.price)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Tuple product : tupleList) {
            System.out.println("----------");
            System.out.println();
            System.out.println("Product Name : " + qProduct.name);
            System.out.println("Product Price : " + qProduct.price);
            System.out.println();
            System.out.println("----------");
        }
    }

    @Test
    void queryDslJPAFactoryBeanTest() {
        QProduct qProduct = QProduct.product;

        List<String> productList = jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (String product : productList) {
            System.out.println("----------");
            System.out.println();
            System.out.println("Product Name : " + product);
            System.out.println();
            System.out.println("----------");
        }
    }

    @Test
    public void auditingTest() {
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(100);

        Product saveProduct = productRepository.save(product);

        System.out.println("productName : " + saveProduct.getName());
        System.out.println("createAt : " + saveProduct.getCreatedAt());
    }

}
