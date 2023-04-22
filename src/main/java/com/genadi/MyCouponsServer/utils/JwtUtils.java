package com.genadi.MyCouponsServer.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genadi.MyCouponsServer.dto.SuccessfulLoginData;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

@Component
public class JwtUtils {
    @Autowired
    ObjectMapper objectMapper;

    public   String createJwtToken(SuccessfulLoginData successfulLoginData) throws JsonProcessingException {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("genadi");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        Key key = new SecretKeySpec("genaSecretKey".getBytes(), HS256.getJcaName());
        return Jwts.builder().setId(String.valueOf(successfulLoginData.getId()))
                .setIssuedAt(new Date())
                .setSubject(objectMapper.writeValueAsString(successfulLoginData))
                .setIssuer(successfulLoginData.getUserType().name())
                .setAudience(String.valueOf(successfulLoginData.getCompanyId()))
                .compact();

    }
}
