package com.agro.project.controller;

import com.agro.project.Repository.SellerRepository;
import com.agro.project.entity.Seller;
import com.agro.project.service.SellerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private SellerDaoImpl sellerDaoImpl;


    @GetMapping("/allSeller")
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @GetMapping("/seller/{buyerId}")
    public Seller getSeller(@PathVariable int buyerId) {
        return sellerDaoImpl.findById(buyerId);
    }


}
