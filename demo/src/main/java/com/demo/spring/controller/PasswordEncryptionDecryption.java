package com.demo.spring.controller;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PasswordEncryptionDecryption {

    private static final String ALGORITHM = "AES";


    private static SecretKeySpec getKey(String salt) {
        byte[] key = salt.getBytes(StandardCharsets.UTF_8);
        byte[] keyBytes = new byte[16];
        System.arraycopy(key, 0, keyBytes, 0, Math.min(key.length, 16));
        return new SecretKeySpec(keyBytes, ALGORITHM);
    }

    public static String encryptPassword(String password, String salt) throws Exception {
        SecretKeySpec key = getKey(salt);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes); // Encode in Base64
    }

    public static String decryptPassword(String encryptedPassword, String salt) throws Exception {
        SecretKeySpec key = getKey(salt);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static void main3(String[] args) {
        try {
            String userPassword = "MySecurePassword";
            String encSalt = "encPass";
//            String decSalt = "decPass";

            String encryptedPassword = encryptPassword(userPassword, encSalt);
            System.out.println("Encrypted Password: " + encryptedPassword);

//            try {
//                String decryptedPassword = decryptPassword(encryptedPassword, decSalt);
//                System.out.println("Decrypted Password with decSalt: " + decryptedPassword);
//            } catch (Exception e) {
//                System.out.println("Error: Unable to decrypt with 'decPass' salt!");
//            }

            String correctlyDecryptedPassword = decryptPassword(encryptedPassword, encSalt);
            System.out.println("Correctly Decrypted Password: " + correctlyDecryptedPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
