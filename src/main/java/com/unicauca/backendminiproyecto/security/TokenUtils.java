package com.unicauca.backendminiproyecto.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class TokenUtils {
    
    private final static String ACCESS_TOKEN_SECRET = "Urb7CRQ9LLwBhDqqPDd0SSjp7PtdbZrOYMJ98Vw5p21xWduMk9ibv06H0BmfUpP";
    private final static Long ACCES_TOKEN_VALIDITY_SECONDS=86_400L;


    public static String createToken(String usuario, String correo){
        long expirationTime = ACCES_TOKEN_VALIDITY_SECONDS *1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("usuario", usuario);

        return Jwts.builder()
        .setSubject(correo)
        .setExpiration(expirationDate)
        .addClaims(extra)
        .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
        .compact();
    }


    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try{
            Claims claims = Jwts.parserBuilder()
            .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
            .build()
            .parseClaimsJws(token)
            .getBody();

            String usuario = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(usuario, null, Collections.emptyList());
        } catch(JwtException e){
            return null;
        }
    }

}
