package com.agro.project.Repository;

import com.agro.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramUserRepository extends JpaRepository<User, Long> {
    User findByChatId(Long chatId);
}
