package com.agro.project.service;

import com.agro.project.Repository.BuyerRepository;
import com.agro.project.entity.Buyer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BuyerDaoImpl implements BuyerDao {
    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer findById(int id) {
        return buyerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Buyer not found with ID: " + id));
    }

    @Override
    @Transactional
    public Buyer save(Buyer buyer) {
        Buyer tempBuyer=new Buyer();
        if (buyer.getName() != null) {
            tempBuyer.setName(buyer.getName());
        }
        if (buyer.getEmail() != null) {
            tempBuyer.setEmail(buyer.getEmail());
        }
        if (buyer.getMobile() != null) {
            tempBuyer.setMobile(buyer.getMobile());
        }
        if (buyer.getAddress() != null) {
            tempBuyer.setAddress(buyer.getAddress());
        }
        if (buyer.getCity() != null) {
            tempBuyer.setCity(buyer.getCity());
        }
        if (buyer.getState() != null) {
            tempBuyer.setState(buyer.getState());
        }
        if (buyer.getPassword() != null) {
            tempBuyer.setPassword(buyer.getPassword());
        }
        if (buyer.getLatitude() != 0) {
            tempBuyer.setLatitude(buyer.getLatitude());
        }
        if (buyer.getLongitude() != 0d) {
            tempBuyer.setLongitude(buyer.getLongitude());
        }

        System.out.println(tempBuyer);
        return buyerRepository.save(tempBuyer);
    }

    @Override
    @Transactional
    public void delete(Buyer buyer) {
    buyerRepository.delete(buyer);
    }

    @Override
    public void update(Buyer buyer) {
        Buyer tempBuyer=new Buyer();
        tempBuyer.setName(buyer.getName());
        tempBuyer.setEmail(buyer.getEmail());
        tempBuyer.setMobile(buyer.getMobile());
        System.out.println(tempBuyer);
        buyerRepository.save(tempBuyer);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Buyer buyer=findById(id);
        buyerRepository.delete(buyer);
    }

    @Override
    public Buyer findByEmail(String email) {
        return buyerRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("Buyer not found with ID: " + email));
    }

}
