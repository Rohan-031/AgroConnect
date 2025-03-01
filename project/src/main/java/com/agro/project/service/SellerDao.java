package com.agro.project.service;

import com.agro.project.entity.Seller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SellerDao {
    public void save(Seller seller);
    public List<Seller> findAll();
    public Seller findById(int id);
    public void delete(int id);
    public void update(Seller seller);
//    public List<Seller> findBySellerName(String sellerName);
}
