package com.agro.project.Repository;

import com.agro.project.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer,Integer> {
    Buyer findByChatId(Long chatId);

    Optional<Buyer> findById(int id);
    Optional<Buyer> findByEmail(String email);
}
