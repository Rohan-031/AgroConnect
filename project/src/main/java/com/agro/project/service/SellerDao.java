package com.agro.project.service;

import com.agro.project.entity.Seller;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SellerDao {
    public Seller save(Seller seller);
    public List<Seller> findAll();
    public Seller findById(int id);
    public void deleteById(int id);
    public void delete(Seller seller);



    public Seller update(Seller seller);
    public Seller findByEmail(String email);
//    public List<Seller> findBySellerName(String sellerName);
}
