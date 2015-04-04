package com.mobilebits.facturacodigocontrol.crypto;

/**
 * Created by iluretar on 02-Apr-15.
 */


public class ARC4 {

    private final byte[] S = new byte[256];


    public ARC4(String key) {
        byte[] cipherKey = key.getBytes();
        if (cipherKey.length < 1 || cipherKey.length > 256) {
            throw new IllegalArgumentException(
                    "key must be between 1 and 256 bytes");
        } else {
            int keyLen = cipherKey.length;
            byte[] t = new byte[256];
            for (int i = 0; i < 256; i++) {
                S[i] = (byte) i;
                t[i] = cipherKey[i % keyLen];
            }
            int j = 0;
            byte tmp;
            for (int i = 0; i < 256; i++) {
                j = (j + S[i] + t[i]) & 0xFF;
                tmp = S[j];
                S[j] = S[i];
                S[i] = tmp;
            }
        }
    }

    public byte[] encrypt(final byte[] plaintext) {
        final byte[] cipherText = new byte[plaintext.length];
        int i = 0, j = 0, k, t;
        byte tmp;
        for (int counter = 0; counter < plaintext.length; counter++) {
            i = (i + 1) & 0xFF;
            j = (j + S[i]) & 0xFF;
            tmp = S[j];
            S[j] = S[i];
            S[i] = tmp;
            t = (S[i] + S[j]) & 0xFF;
            k = S[t];
            cipherText[counter] = (byte) (plaintext[counter] ^ k);
        }
        return cipherText;
    }

    public String generate(String plaintext){
        byte[] cipher;

        cipher = encrypt(plaintext.getBytes());

        StringBuilder cipherText = new StringBuilder(cipher.length * 2);
        for(byte b: cipher)
            cipherText.append(String.format("%02x", b & 0xff));
        return cipherText.toString().toUpperCase();

    }
}
