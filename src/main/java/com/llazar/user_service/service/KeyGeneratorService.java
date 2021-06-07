package com.llazar.user_service.service;





import com.llazar.user_service.service.UserRequest;
import org.springframework.stereotype.Service;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;



@Service
public class KeyGeneratorService {



    private static KeyFactory keyFactory;

    /**
     * Helper class for the private key
     * Utilized the RSA algorithm
     *
     *
     */


    public KeyGeneratorService() throws NoSuchAlgorithmException {
        keyFactory = KeyFactory.getInstance("RSA");
    }

    private static PrivateKey generatePrivateKey(String key)
            throws InvalidKeySpecException {

        key = parsePrivateKey(key);
        byte[] encoded = Base64.getDecoder().decode(key);

        System.out.println(" bytes encoded are ");
        System.out.println(Arrays.toString(encoded));

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        return keyFactory.generatePrivate(keySpec);
    }

    public static String parsePrivateKey(String key) {
        key = key.replace("-----BEGIN PRIVATE KEY-----\n", "");
        key = key.replace("-----END PRIVATE KEY-----", "");
        key = key.replace("\n", "");
        key = key.trim();
        return key;
    }

    public PrivateKey getPrivateKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        return generatePrivateKey(key);
    }
}
