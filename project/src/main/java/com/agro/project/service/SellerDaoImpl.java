package com.agro.project.service;

import com.agro.project.Repository.SellerRepository;
import com.agro.project.entity.Seller;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SellerDaoImpl implements SellerDao {
    @Autowired
    private final SellerRepository sellerRepository;

    public SellerDaoImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }


    @Override
    @Transactional
    public Seller save(Seller seller) {
        Seller tempSeller = new Seller();

        if (seller.getName() != null) tempSeller.setName(seller.getName());
        if (seller.getEmail() != null) tempSeller.setEmail(seller.getEmail());
        if (seller.getMobile() != null) tempSeller.setMobile(seller.getMobile());
        if (seller.getAddress() != null) tempSeller.setAddress(seller.getAddress());
        if (seller.getCity() != null) tempSeller.setCity(seller.getCity());
        if (seller.getState() != null) tempSeller.setState(seller.getState());
        if (seller.getPassword() != null) tempSeller.setPassword(seller.getPassword());
        if (seller.getLatitude() != 0) tempSeller.setLatitude(seller.getLatitude());
        if (seller.getLongitude() != 0) tempSeller.setLongitude(seller.getLongitude());

        return sellerRepository.save(tempSeller);
    }

    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller findById(int id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Seller not found with ID: " + id));
    }

    @Override
    @Transactional
    public void delete(Seller seller) {
        sellerRepository.delete(seller);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        sellerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Seller update(Seller seller) {
        return save(seller);
    }

    @Override
    public Seller findByEmail(String email) {
        return sellerRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("Seller not found with email: " + email));

    }
}
