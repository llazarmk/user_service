package com.llazar.user_service.configuration;


import com.llazar.user_service.security.JwtTokenProvider;
import com.llazar.user_service.service.KeyGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.PrivateKey;

@Configuration
@RequiredArgsConstructor
public class UserConfiguration {

    @Value("${user-service.private-key}")
    private String privateKeyString;

    @Value("${user-service.token-expiry-seconds}")
    private int tokenExpirySeconds;

    private final KeyGeneratorService keyGeneratorService;

    @Bean
    public JwtTokenProvider jwtTokenProvider() throws Exception {
        PrivateKey key  = keyGeneratorService.getPrivateKey(privateKeyString);
        return new JwtTokenProvider(key,tokenExpirySeconds);
    }


}
