package com.agro.project.service;

import com.agro.project.entity.Buyer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BuyerDao {
    public List<Buyer> findAll();
    public Buyer findById(int id);
    public Buyer save(Buyer buyer);
    public void delete(Buyer buyer);
    public void update(Buyer buyer);
    public void deleteById(int id);
    public Buyer findByEmail(String email);

}
