package com.agro.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chatId;
    private String name;
    private String email;
    private String mobile;

    public Seller() {}

    public Seller(Long chatId, String name, String email, String mobile) {
        this.chatId = chatId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public Long getId() { return id; }
    public Long getChatId() { return chatId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }

    public void setId(Long id) { this.id = id; }
    public void setChatId(Long chatId) { this.chatId = chatId; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setMobile(String mobile) { this.mobile = mobile; }
}
