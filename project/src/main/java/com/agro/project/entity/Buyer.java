package com.agro.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "chatId")
    private Long chatId;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    public Buyer() {}

    public Buyer(Long chatId, String name, String email, String mobile) {
        this.chatId = chatId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public Buyer(int id, Long chatId, String name, String email, String password, String mobile, String address, String city, String state, double latitude, double longitude) {
        this.id = id;
        this.chatId = chatId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
        this.city = city;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Buyer(int id, String name, String email, String password, String mobile, String address, String city, String state, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
        this.city = city;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Buyer(String name, String email, String password, String mobile, String city, String address, String state, double longitude, double latitude) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.city = city;
        this.address = address;
        this.state = state;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
