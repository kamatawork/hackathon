package com.hackathon.hackathon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MST_USER")
public class UserEntity {

    @Id
    @Column(name = "USER_ID", length = 8, nullable = false)
    private String userId;

    @Column(name = "USER_NAME", length = 40, nullable = false)
    private String userName;

    @Column(name = "PASSWORD", length = 8)
    private String password;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
