package com.example.loginsidechannels;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AuthUtils {

	public static String generateSalt() throws NoSuchAlgorithmException {
		String salt  = "";
		byte[] buffer = new byte[512];
		new SecureRandom().nextBytes(buffer);
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(buffer);
		byte[] digest = md.digest();
		for (int i=0; i<digest.length; i++) {
			salt += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1).toUpperCase();
		}
		return salt;
	}
	
	public static String hash(String password, String salt) throws NoSuchAlgorithmException {
		String hashedPassword = "";
		byte[] buffer = (password + salt).getBytes();
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(buffer);
		byte[] digest = md.digest();
		for (int i=0; i<digest.length; i++) {
			hashedPassword += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1).toUpperCase();
		}
		return hashedPassword;
	}
	
}
