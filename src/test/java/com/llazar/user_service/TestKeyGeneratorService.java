package com.llazar.user_service;

import com.llazar.user_service.service.KeyGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;



public class TestKeyGeneratorService {


    private KeyGeneratorService keyGeneratorService;
    private String token;

    @BeforeEach
    void init() throws NoSuchAlgorithmException {
        token = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC+IK/VOrRbaVCU\nwAtONVj1d4Y4pooVr\n-----END PRIVATE KEY-----\n";
        keyGeneratorService = new KeyGeneratorService();
    }

    @Test
    void test_parsePrivateKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
       //JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(parsePrivateKey(token), 6000);
       String expected = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC+IK/VOrRbaVCUwAtONVj1d4Y4pooVr";
       String key = keyGeneratorService.parsePrivateKey(token);
       Assert.assertEquals(key,expected);

    }

}
