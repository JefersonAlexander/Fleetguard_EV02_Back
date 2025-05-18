package com.fleetGuard360.api_gateway.filter;


import com.fleetGuard360.api_gateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;

import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpStatus;



@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {


    @Autowired
    private RouteValidator validator;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String requestPath = exchange.getRequest().getURI().getPath();
            boolean isSecuredRoute = validator.isSecured.test(exchange.getRequest());

            if (isSecuredRoute) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }

                String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
                String token = null;

                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    token = authHeader.substring(7).trim(); 
                } else {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED); 
                    return exchange.getResponse().setComplete();
                }

                try {
                    jwtUtil.validateToken(token);
                  
                } catch (Exception e) {
                 
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            } else {
                 
            }

            // Si la ruta no está asegurada o la autenticación/validación fue exitosa, continúa la cadena
            return chain.filter(exchange);
        };
    }

    public static class Config {
        // Configuración futura (si se desea)
    }
}