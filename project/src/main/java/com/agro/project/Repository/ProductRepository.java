package com.agro.project.Repository;

import com.agro.project.entity.Buyer;
import com.agro.project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Optional<Product> findByName(String name);
    public List<Product> findByCategory(String category);
    public Optional<Product> findById(int id);

}
