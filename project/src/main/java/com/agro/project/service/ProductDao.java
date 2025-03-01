package com.agro.project.service;

import com.agro.project.entity.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getProducts();
    public Product findById(int id);
    public Product save(Product product);
    public void delete(Product product);
    public Product update(Product product);
}
