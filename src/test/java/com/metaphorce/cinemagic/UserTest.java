package com.metaphorce.cinemagic;

import com.metaphorce.cinemagic.entities.User;
import com.metaphorce.cinemagic.enums.UserType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        // Initialize a sample User object before each test
        user = new User("Checo", "checo@example.com", "password123", UserType.Spectator, new Timestamp(System.currentTimeMillis()));
    }

    @Test
    public void testUserConstructor() {
        assertEquals("Checo", user.getName());
        assertEquals("checo@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals(UserType.Spectator, user.getUserType());
        assertNotNull(user.getRegistrationDate());
    }

    @Test
    public void testSettersAndGetters() {
        user.setName("Morty");
        user.setEmail("morty@example.com");
        user.setPassword("newpassword");

        assertEquals("Morty", user.getName());
        assertEquals("morty@example.com", user.getEmail());
        assertEquals("newpassword", user.getPassword());
    }
}

