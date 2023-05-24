package com.genadi.MyCouponsServer.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genadi.MyCouponsServer.dto.SuccessfulLoginData;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    public final static String JWT_KEY = "awskjd haskdh kasdh askudy saclawefy efcb239r7013 nsc ]98@!$!@#%R!(@E* !@( Usdlcfh wiqeuyd ";
    @Autowired
    ObjectMapper objectMapper;

    public static Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(JWT_KEY);
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Claims claims = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }
    public  String createJWT(SuccessfulLoginData succssfulLoginDetails) throws JsonProcessingException {
        String jsonLoginDetails = objectMapper.writeValueAsString(succssfulLoginDetails);
        return createJWT("0", "Avi", jsonLoginDetails, 0);
    }

    public  String createJWT(String subject) {
        return createJWT("0", "Avi", subject, 0);
    }

    private  String createJWT(String id, String issuer, String subject, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(JWT_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public  void validateToken(String token) throws Exception {
        Claims claims = decodeJWT(token.replace("Bearer ", ""));
    }
}
