package com.newproject.basicprojectskeleton.configuration.security.filter;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtTokenConfig {
    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    public static final String CONTENT_TYPE = "application/json";
    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    static final Date DATE_EXPIRATION = new Date(System.currentTimeMillis() + 3600000);

    private JwtTokenConfig() {
    }
}
