package com.agro.project.controller;

import com.agro.project.Repository.BuyerRepository;
import com.agro.project.Repository.SellerRepository;
import com.agro.project.entity.Buyer;
import com.agro.project.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private SellerRepository sellerRepository;

    @GetMapping("/sada")
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    @GetMapping("/sdas")
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }
}
