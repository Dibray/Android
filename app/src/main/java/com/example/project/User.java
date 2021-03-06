package com.example.project;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey (autoGenerate = true)
    private long id;

    private String email;
    private String password;
    private String nickname;

    private long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setId(long id) {
        this.id = id;
    }

    private void setEmail(String email) {
        if (email.contains("@"))
            this.email = email;
    }

    private void setPassword(String pass) {
        this.password = pass;
    }

    private void setNickname() {
        this.nickname = email;
    }

    public User(String email, String pass) {
        setEmail(email);
        setPassword(pass);
        setNickname();
    }
}
