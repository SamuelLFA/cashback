package br.com.boticario.cashback.service;

import br.com.boticario.cashback.model.Reseller;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${TOKEN_EXPIRATION}")
    private String expiration;

    @Value("${TOKEN_SECRET}")
    private String secret;

    public String createToken(Authentication authentication) {
        var user = (Reseller) authentication.getPrincipal();
        var date = new Date();
        var expirationDate  = new Date(date.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("Cashback")
                .setSubject(user.getId().toString())
                .setIssuedAt(date)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserId(String token) {
        var claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
