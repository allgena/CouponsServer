package com.genadi.MyCouponsServer.utils;

import com.genadi.MyCouponsServer.bean.User;
import io.jsonwebtoken.Jwts;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

public class JwtUtils {


    public static  String createJwtToken(User user){
        Key key = new SecretKeySpec("genaSecretKey".getBytes(), HS256.getJcaName());

        return Jwts.builder().claim("username", user.getUserName())
                .claim("password", user.getPassword())
                .claim("company", user.getCompany()).compact();

    }
}
