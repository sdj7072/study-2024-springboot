package com.springboot.api.service.impl;

import com.springboot.api.data.dao.ProductDAO;
import com.springboot.api.data.entity.Product;
import com.springboot.api.dto.ProductDto;
import com.springboot.api.dto.ProductResponseDto;
import com.springboot.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        Optional<Product> product = productDAO.selectProduct(number);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(product.get().getNumber());
        productResponseDto.setName(product.get().getName());
        productResponseDto.setPrice(product.get().getPrice());
        productResponseDto.setStock(product.get().getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saveProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(saveProduct.getNumber());
        productResponseDto.setName(saveProduct.getName());
        productResponseDto.setPrice(saveProduct.getPrice());
        productResponseDto.setStock(saveProduct.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changeProduct = productDAO.updateProduct(number, name);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changeProduct.getNumber());
        productResponseDto.setName(changeProduct.getName());
        productResponseDto.setPrice(changeProduct.getPrice());
        productResponseDto.setStock(changeProduct.getStock());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}
