package org.abc;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class RandomKeyGenerator {
    private static final int SIZE = 160;
    public static void main(String[] args) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        int noOfIterations = SIZE / 65 + 1;
        for(int i = 0; i< noOfIterations; i++) {
            byte[] sha256 = generateSHA256(String.valueOf(new Random().nextLong()));
            sb.append(toHexString(sha256).toUpperCase());
        }
        System.out.println(sb.toString().substring(0,160));
    }

    private static byte[] generateSHA256(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        return number.toString(16);
    }


}
