package com.demo.spring.controller;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class EncryptionDecryptionExample {

	// Method to generate a SecretKey for AES
	public static SecretKey generateKey() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128); // AES-128
		return keyGen.generateKey();
	}

	public static String encrypt(String plainText, SecretKey key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
		return Base64.getEncoder().encodeToString(encryptedBytes); // Encode to Base64
	}

	public static String decrypt(String encryptedText, SecretKey key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
		byte[] decryptedBytes = cipher.doFinal(decodedBytes);
		return new String(decryptedBytes, StandardCharsets.UTF_8);
	}

	public static void main4(String[] args) throws Exception {
		String userPassword = "MySecurePassword";

		SecretKey decryptionSalt = generateKey();
		SecretKey encryptionSalt = generateKey();

		String encryptedPassword = "cRr0fFE3d7EtCTVEYSmKNGTzpPQRur00BFHwt9xBP40=";
		String decryptedPassword ="";

		List<String> taskList = Arrays.asList("enc", "dyc");
		try {
			if (taskList.get(1).equals("enc")) {
				encryptedPassword = encrypt(userPassword, encryptionSalt);
				System.out.println("Encrypted Password: " + encryptedPassword);
			} else {
				decryptedPassword = decrypt(encryptedPassword, decryptionSalt);
				System.out.println("Decrypted Password: " + decryptedPassword);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
