package com.metaphorce.cinemagic.entities;

public class Auth {
    private String token;

    public Auth(String token) {
        this.token = token;
    }

    public Auth() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "token='" + token + '\'' +
                '}';
    }
}
