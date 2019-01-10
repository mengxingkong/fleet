package com.warren.fleet.security.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

@Component
public class JwtTokenUtil implements Serializable{


    private static final long serialVersionUID = -7258924821762750113L;

//    public static final String ROLE_REFRESH_TOKEN = "ROLE_REFRESH_TOKEN";
//    private static final String CLAIM_KEY_USER_ID = "user_id";
//    private static final String CLAIM_KEY_AUTHORITIES = "scope";
//    private static final String CLAIM_KEY_ACCOUNT_ENABLED = "enabled";
//    private static final String CLAIM_KEY_ACCOUNT_NON_LOCKED = "non_locked";
//    private static final String CLAIM_KEY_ACCOUNT_NON_EXPIRED = "non_expired";
//    private static final String CLAIM_KEY_USER_ACCOUNT = "sub";
//    private static final String CLAIM_KEY_CREATED = "created";
//    private final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
//
//    @Value("${jwt.access_token}")
//    private Long access_token_expiration;
//
//    @Value("${jwt.refresh_token}")
//    private Long refresh_token_expiration;

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    private static final String CLAIM_KEY_ROLES = "aud";

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String generateUserNameFromToken(String token){
        String username;
        try{
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        }catch (Exception e){
            username = null;
        }
        return username;
    }

    public String getTokenRoleFromToken(String token){
        String tokenRoles;
        try{
            final Claims claims = getClaimsFromToken(token);
            tokenRoles = claims.getAudience();
        }catch (Exception e){
            e.printStackTrace();
            tokenRoles = null;
        }
        return tokenRoles;
    }

    private Date getCreatedDateFromToken( String token ){
        Date createDate;
        try{
            final Claims claims = getClaimsFromToken(token);
            createDate = new Date( (Long) claims.get(CLAIM_KEY_CREATED) );
        }catch (Exception e){
            e.printStackTrace();
            createDate = null;
        }
        return createDate;
    }

    private Date getExpirationDateFromToken( String token ){
        Date expirationDate;
        try{
            final Claims claims = getClaimsFromToken(token);
            expirationDate = claims.getExpiration();
        }catch (Exception e){
            e.printStackTrace();
            expirationDate = null;
        }
        return expirationDate;
    }

    private Claims getClaimsFromToken(String token){
        Claims claims;
        try{
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        }catch (Exception e){
            e.printStackTrace();
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate(){
        return new Date( System.currentTimeMillis()+ expiration*1000 );
    }

    private boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before( new Date() );
    }

    private boolean isCreatedBeforeLastModified(Date created,Date lastmodified){
        return ( lastmodified !=null && created.before(lastmodified) );
    }

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        claims.put(CLAIM_KEY_ROLES,userDetails.getAuthorities());
        return generateToken(claims);
    }

    private String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration( generateExpirationDate() )
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public boolean canTokenBeRefresh(String token,Date lastmodified){
        final Date created = getCreatedDateFromToken( token );
        return !isCreatedBeforeLastModified( created,lastmodified ) && !isTokenExpired( token );
    }

    public String refreshToken( String token ){
        String refreshedToken;
        try{
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED,new Date());
            refreshedToken = generateToken(claims);
        }catch (Exception e){
            e.printStackTrace();
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public String refreshToken(UserDetails userDetails){
        return generateToken(userDetails);
    }


    public boolean validateToken(String token,Date lastmodified){
        final Date created = getCreatedDateFromToken( token );
        return ( !isTokenExpired(token) && !isCreatedBeforeLastModified(created,lastmodified) );
    }

}