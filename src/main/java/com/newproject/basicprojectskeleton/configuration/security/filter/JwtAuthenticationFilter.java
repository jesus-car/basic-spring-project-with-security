package com.newproject.basicprojectskeleton.configuration.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newproject.basicprojectskeleton.presentation.dto.input.UserLoginRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import static com.newproject.basicprojectskeleton.configuration.security.filter.JwtTokenConfig.*;


@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // Asegurarse de que la solicitud es POST y que el Content-Type es application/json
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Método de autenticación no soportado: " + request.getMethod());
        }

        if (!request.getContentType().equals(CONTENT_TYPE)) {
            throw new AuthenticationServiceException("Content-Type no soportado: " + request.getContentType());
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;

        try {
            UserLoginRequest userLoginRequest = new ObjectMapper().readValue(request.getInputStream(), UserLoginRequest.class);
            usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    userLoginRequest.getUsername(),
                    userLoginRequest.getPassword()
            );
        } catch (IOException e) {
            throw new AuthenticationServiceException("Invalid request");
        }

        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();

        String username = user.getUsername();

        Claims claims = Jwts.claims()
                .add("username", username)
                .add("authorities", new ObjectMapper().writeValueAsString(user.getAuthorities()))
                .build();

        String token = Jwts.builder()
                .subject(username)
                .claims(claims)
                .issuedAt(new Date())
                .expiration(DATE_EXPIRATION)
                .signWith(SECRET_KEY)
                .compact();

        Map<String,String> body = Map.of(
                "token", token,
                "username", username,
                "message", "User authenticated successfully"
        );

        response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN + token);
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setContentType(CONTENT_TYPE);
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Map<String,String> body = Map.of(
                "message", "Authentication failed",
                "error", failed.getMessage()
        );

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setContentType(CONTENT_TYPE);
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
