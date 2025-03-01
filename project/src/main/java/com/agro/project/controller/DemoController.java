package com.agro.project.controller;

import com.agro.project.entity.User;
import com.agro.project.Repository.TelegramUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class DemoController {

    @Autowired
    private TelegramUserRepository repository;

    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
