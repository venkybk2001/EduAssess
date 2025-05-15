package com.springboot.jpa.mvc.Util;

import org.springframework.stereotype.Service;

@Service
public class EncryptionUtil implements Encryption{
	
    private static final String ENCRYPTION_KEY = "ijklmnop";

    public String encrypt(String original) {

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            encrypted.append
            			((char) (original.charAt(i) 
            						^ ENCRYPTION_KEY.charAt
            							(i % ENCRYPTION_KEY.length())));
        }
        return encrypted.toString();
    }

    public String decrypt(String encrypted) {

        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encrypted.length(); i++) {
            decrypted.append
            			((char) (encrypted.charAt(i)
            						^ ENCRYPTION_KEY.charAt
            							(i % ENCRYPTION_KEY.length())));
        }
        return decrypted.toString();
    }

}
