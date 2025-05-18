package com.fleetGuard360.api_gateway.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys; 


@Component
public class JwtUtil {

    @Value("${jwt.key}")
    private String secret;

    public void validateToken(final String token) {
        // Usar el texto en UTF-8 para la validación del token
        Jwts.parserBuilder().setSigningKey(secret.getBytes(StandardCharsets.UTF_8)).build().parseClaimsJws(token);
    }

}