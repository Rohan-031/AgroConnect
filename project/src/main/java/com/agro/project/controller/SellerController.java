package com.agro.project.controller;

import com.agro.project.Repository.SellerRepository;
import com.agro.project.entity.Buyer;
import com.agro.project.entity.Seller;
import com.agro.project.service.SellerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private SellerDaoImpl sellerDaoImpl;

    @PostMapping("/signup")
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerDaoImpl.save(seller);
    }

    @GetMapping("/login")
    public Seller login(@RequestParam("emailId") String emailId, @RequestParam("password") String password) {
        Seller tempSeller=sellerDaoImpl.findByEmail(emailId);
        if(tempSeller==null) {
            System.out.println("Account doesn't exist");
            throw new RuntimeException("Account doesn't exist");
        }
        if(tempSeller.getPassword().equals(password)) {
            return tempSeller;
        }
        throw new RuntimeException("Wrong password");
    }

    // Get all Sellers
    @GetMapping("/all")
    public List<Seller> getAllSellers() {
        return sellerDaoImpl.findAll();
    }

    // Get a Seller by ID
    @GetMapping("/{id}")
    public Seller getSellerById(@PathVariable int id) {
        return sellerDaoImpl.findById(id);
    }

    // Update a Seller
    @PutMapping("/update")
    public Seller updateSeller(@RequestBody Seller seller) {
        return sellerDaoImpl.update(seller);
    }

    // Delete a Seller by ID
    @DeleteMapping("/delete/{id}")
    public String deleteSeller(@PathVariable int id) {
        sellerDaoImpl.deleteById(id);
        return "Seller deleted with ID: " + id;
    }


}
