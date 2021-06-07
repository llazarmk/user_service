package com.llazar.user_service.security;

import com.llazar.user_service.model.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.PrivateKey;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public final class JwtTokenProvider {

    private final PrivateKey jwtSecret;

    private final long expiryTimeSeconds;

    /**
     * Constructs the JwtTokenProvider
     *
     * @param expiryTimeSeconds duration in seconds before the JWT token expires.
     */
    public JwtTokenProvider(PrivateKey jwtSecret, long expiryTimeSeconds) {
        this.jwtSecret = jwtSecret;
        this.expiryTimeSeconds = expiryTimeSeconds;
    }

    /**
     * Creates a JWT token for the provided {@link UserModel}.
     * @param userModel the logged in user to create a JWT token for.
     */
    public String createJwtToken(UserModel userModel) {
        return Jwts.builder()
                .setClaims(getJwtClaimsMap(userModel))
                .signWith(SignatureAlgorithm.RS256, jwtSecret)
                .compact();
    }

    /**
     * Creates the claims to be encoded in the JWT token.
     */
    private Map<String, Object> getJwtClaimsMap(UserModel userModel) {
        Instant currentTime = Instant.now();

        Map<String, Object> claims = new HashMap<>();
        claims.put("user", userModel.getUsername());
        claims.put("acct", Long.toString(userModel.getUserid()));
        claims.put("name", userModel.getFirst_name() + " " + userModel.getLast_name());
        claims.put("iat", currentTime.getEpochSecond());
        claims.put("exp", currentTime.getEpochSecond() + expiryTimeSeconds);

        return claims;
    }
}