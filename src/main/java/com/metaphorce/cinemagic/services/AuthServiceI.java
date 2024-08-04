package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Auth;
import com.metaphorce.cinemagic.entities.User;

public interface AuthServiceI{
    Auth login(User user);
    Auth register(User user);
}
