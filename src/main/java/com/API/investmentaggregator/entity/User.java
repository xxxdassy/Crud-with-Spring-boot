package com.API.investmentaggregator.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    private Instant updatedTimeStamp;

    private User() {}

    public User(UUID userId, String username, String email, String password, Instant creationTimeStamp, Instant updatedTimeStamp) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.creationTimeStamp = creationTimeStamp;
        this.updatedTimeStamp = updatedTimeStamp;
    }

    public UUID getUserId() {
        return this.userId;
    }
    public String getUsername() {
        return this.username;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public Instant getCreationTimeStamp() {
        return this.creationTimeStamp;
    }
    public Instant getUpdatedTimeStamp() {
        return this.updatedTimeStamp;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCreationTimeStamp(Instant creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }
    public void setUpdatedTimeStamp(Instant updatedTimeStamp) {
        this.updatedTimeStamp = updatedTimeStamp;
    }

}
