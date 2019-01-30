/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author luis
 */
@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    boolean tokenValido(String token) {
        //objeto tipo que armazena as reividicações do token/ alegando que é o usuario armazenado no claims
        Claims claims = getClaims(token);
        if (claims != null) {
            //pega username e retorna usuario
            String username = claims.getSubject();
            //data expiração
            Date expirationDate = claims.getExpiration();
            //data atual
            Date now = new Date(System.currentTimeMillis());
            //se tem usuario e se data diferente de null e data agora é antes do token 
            if (username != null && expirationDate != null && now.before(expirationDate)) {
                return true;
            }

        }
        return false;
    }

    String getUsername(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    //obter claims a partir de um token
    private Claims getClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

}
