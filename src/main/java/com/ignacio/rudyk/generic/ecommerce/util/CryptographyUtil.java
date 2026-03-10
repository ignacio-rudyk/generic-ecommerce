package com.ignacio.rudyk.generic.ecommerce.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class CryptographyUtil {

    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    public static String encrypt(String rawPassword, String salt) throws NoSuchAlgorithmException {
        byte[] saltBytes = Base64.getDecoder().decode(salt);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(saltBytes);
        byte[] hashedPassword = md.digest(rawPassword.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

}
