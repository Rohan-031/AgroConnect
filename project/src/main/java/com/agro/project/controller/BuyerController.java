package com.agro.project.controller;

import com.agro.project.Repository.BuyerRepository;
import com.agro.project.Repository.SellerRepository;
import com.agro.project.entity.Buyer;
import com.agro.project.entity.Seller;
import com.agro.project.service.BuyerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/buyer")
public class BuyerController {

    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private BuyerDaoImpl buyerDaoImpl;

    @GetMapping("/allBuyer")
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    @GetMapping("/{buyerId}")
    public Buyer getBuyer(@PathVariable int buyerId) {
        return buyerDaoImpl.findById(buyerId);
    }

    @GetMapping("/login")
    public Buyer login(@RequestParam String emailId,@RequestParam String password) {
            Buyer tempBuyer=buyerDaoImpl.findByEmail(emailId);
            if(tempBuyer==null) {
                System.out.println("Account doesn't exist");
                throw new RuntimeException("Account doesn't exist");
            }
            if(tempBuyer.getPassword().equals(password)) {
                return tempBuyer;
            }
            throw new RuntimeException("Wrong password");
    }

    @PostMapping("/signup")
    public Buyer login(@RequestBody Buyer theBuyer) {
      theBuyer.setId(0);
        return buyerDaoImpl.save(theBuyer);
    }


}
