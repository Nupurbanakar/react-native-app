package com.form.form.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.form.form.model.User;
import com.form.form.repository.UserRepository;

public class LoginServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private LoginService loginService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password123");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User registeredUser = loginService.register(user);

        assertNotNull(registeredUser);
        assertEquals("testUser", registeredUser.getUsername());
    }

    @Test
    public void testLogin_UserNotFound() {
        String username = "nonExistentUser";
        String password = "password";

        when(userRepository.findByUsername(username)).thenReturn(null);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            loginService.login(username, password);
        });

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        assertEquals("User not found", exception.getReason());
    }

    @Test
    public void testLogin_InvalidPassword() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password123");

        when(userRepository.findByUsername("testUser")).thenReturn(user);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            loginService.login("testUser", "wrongPassword");
        });

        assertEquals(HttpStatus.UNAUTHORIZED, exception.getStatusCode());
        assertEquals("Invalid password", exception.getReason());
    }

    @Test
    public void testLogin_Success() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password123");

        when(userRepository.findByUsername("testUser")).thenReturn(user);

        User loggedInUser = loginService.login("testUser", "password123");

        assertNotNull(loggedInUser);
        assertEquals("testUser", loggedInUser.getUsername());
    }
}
