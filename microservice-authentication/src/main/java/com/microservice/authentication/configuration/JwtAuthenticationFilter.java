package com.microservice.authentication.configuration;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.microservice.authentication.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Value("${jwt.key}")
    private String jwtKey;

    private final UserRepository userRepository;

    public JwtAuthenticationFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                  HttpServletResponse response, 
                                  FilterChain filterChain) throws ServletException, IOException, java.io.IOException {  // Añade las excepciones aquí
        
        try {
            String token = extractToken(request);
            if (token != null && validateToken(token)) {
                Claims claims = extractClaims(token);
                String userId = claims.getSubject();

                userRepository.findById(Long.parseLong(userId)).ifPresent(user -> {
                    List<SimpleGrantedAuthority> authorities = user.getRole().getPermissions().stream()
                        .map(permission -> new SimpleGrantedAuthority(permission.getPermissionName()))
                        .collect(Collectors.toList());
                    
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName()));

                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        user, null, authorities);
                    
                    SecurityContextHolder.getContext().setAuthentication(auth);
                });
            }
            
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            logger.error("Error en el filtro JWT", e);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error de autenticación");
        }
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(jwtKey.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            logger.error("Token JWT inválido", e);
            return false;
        }
    }

    private Claims extractClaims(String token) {
        return Jwts.parser()
            .setSigningKey(jwtKey.getBytes(StandardCharsets.UTF_8))
            .parseClaimsJws(token)
            .getBody();
    }
}
