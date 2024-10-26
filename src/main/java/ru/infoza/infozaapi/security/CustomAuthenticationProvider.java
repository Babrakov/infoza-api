package ru.infoza.infozaapi.security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        if (canConnectWithCredentials(username, password)) {
            return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    private boolean canConnectWithCredentials(String username, String password) {
        // todo move string to env
        String url = "jdbc:mysql://localhost:3307/info"; // Замените на URL вашей базы данных
        try {
            DriverManager.getConnection(url, username, password);
            return true; // Соединение успешно
        } catch (
                Exception e) {
            return false;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
