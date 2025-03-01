package com.agro.project.service;

import com.agro.project.Repository.SellerRepository;
import com.agro.project.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SellerDaoImpl implements SellerDao {
    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public void save(Seller seller) {

    }

    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller findById(int id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Buyer not found with ID: " + id));
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Seller seller) {

    }
}
