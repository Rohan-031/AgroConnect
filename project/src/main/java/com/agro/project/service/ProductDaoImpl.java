package com.agro.project.service;

import com.agro.project.Repository.ProductRepository;
import com.agro.project.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Buyer not found with ID: " + id));
    }

    @Override
    @Transactional
    public Product save(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    @Transactional
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product update(Product product) {
        return null;
    }
}
