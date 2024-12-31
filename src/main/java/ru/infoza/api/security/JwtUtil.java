package ru.infoza.api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    // todo remove deprecated methods
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, Base64.getDecoder().decode(secretKey))
                .compact();
    }

    public boolean validateToken(String token, String username) {
        String tokenUsername = extractUsername(token);
        return (username.equals(tokenUsername) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public Date extractExpiration(String token) {
        return getClaims(token).getExpiration();
    }

    // todo remove deprecated methods
    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(Base64.getDecoder().decode(secretKey))
                .build() // Создаем объект JwtParser
                .parseClaimsJws(token) // Вызываем метод parseClaimsJws на объекте JwtParser
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

}
