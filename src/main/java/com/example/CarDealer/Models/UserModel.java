package com.example.CarDealer.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @JsonProperty("username")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("phone_no")
    private String phoneNo;

    public UserModel() {
    }

    public UserModel(int userid, String name, String email, String password, String phoneNo) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
