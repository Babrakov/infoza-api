package ru.infoza.infozaapi.security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collections;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.infoza.infozaapi.model.ZIst;
import ru.infoza.infozaapi.repository.ZIstRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  private final ZIstRepository zIstRepository;

  public CustomAuthenticationProvider(ZIstRepository zIstRepository) {
    this.zIstRepository = zIstRepository;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = (String) authentication.getCredentials();

    if (canConnectWithCredentials(username, password)) {
      ZIst zIst = zIstRepository.findByVcUSR(username)
          .orElseThrow(() -> new UsernameNotFoundException("User not found"));
      UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(zIst,
          password, Collections.emptyList());
      SecurityContextHolder.getContext().setAuthentication(userToken);
      return userToken;
    } else {
      throw new BadCredentialsException("Invalid username or password");
    }
  }

  private boolean canConnectWithCredentials(String username, String password) {
    String url = "jdbc:mysql://localhost:3307/info"; // Замените на URL вашей базы данных

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      return true;
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
