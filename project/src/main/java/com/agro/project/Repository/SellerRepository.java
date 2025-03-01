package com.agro.project.Repository;

import com.agro.project.entity.Buyer;
import com.agro.project.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
    Seller findByChatId(Long chatId);
    Optional<Seller> findById(int id);
    Optional<Seller> findByEmail(String email);
}
