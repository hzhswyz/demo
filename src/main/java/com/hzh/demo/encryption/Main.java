package com.hzh.demo.encryption;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class Main {
    public static void main(String []args){
       /* String s = "test";
        String c1 = RSAUtils.encryptByPublic(s.getBytes(),null);
        String m1 = RSAUtils.decryptByPrivate(c1,null);
        String c2 = RSAUtils.encryptByPrivate(s.getBytes(),null);
        String m2 = RSAUtils.decryptByPublic(c2,null);
        System.out.println(c1);
        System.out.println(m1);
        System.out.println(c2);
        System.out.println(m2);
        long startTime = System.currentTimeMillis();
        RSAUtils.KeyObject keyObject = RSAUtils.generateKeyPairarray();
        long endTime = System.currentTimeMillis();
        String s = "password";
        String c1 = RSAUtils.encryptByPublic(s.getBytes(),keyObject.publicKey);
        System.out.println(c1);
        String c2 = RSAUtils.decryptByPrivate(c1,keyObject.privateKey);
        System.out.println(c2);

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

       String[] strings = RSAUtils.getKeyPair();
        System.out.println(strings[0]);
        System.out.println(strings[1]);*/

        RSAPrivateKey privateKey = RSAUtils.getPrivateKeyFromString("MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKvG0NVGZFzqSHqR0aj+omREANf5mFwr5rrc24KBIrbpn0LDiYBLAlcHi8u73AoqcXfInaveNttEx0kK8zhWXAmRgoAvQWyKZM9xg4cVPQArBdufh2uwlG5DUi+Jn4x+F1JRPGH43hi5oCQmhNMZjc6bn1dOdX3UX8pTgunrID5ZAgMBAAECgYAff1Axmzux8d+iYfSQyUgbnICPGZw/YmlnYDH75xPneEUUp+ghlx9xt9eBXwwE7S1rKmUG67MhV6Y3FYPtk6BCb+5+tRDntWE7tveUBJtn2qhmunz41DPmoqp57twuIk4m4712gl2fmnSQdoCpIyy6tGyTSe9OQpbjnthL/DV6dQJBANoUt3fYJ4txKWztajNlslb0RlxMhtITN1w11Gg7Cw9QpxC2qH3niAV1XThEld3d9bHct4+sSLWf5sNY7WBWfUcCQQDJpPz7gRzP5PKDZdcW0B1ylHuSyEwvjDXYyuwtK7uZ7h5FIzwX9u2VdzbrgAzALI785+Orjs+4JoBx+q0BtrdfAkBw9W4au3GwPoswisEJolF/zMNtJ45l3eI89vzwiDSwWBxRAevAW18PRL1mWdAuvbt3x1WlK531xb9ny/YYgnQdAkBycqd35E9DG/IdbBcJhrPADdCZff/n2M/TLVGhTbob4w/hM99uxqMQe2p7feE+zcuWddM90z/IiGnMx3ecimVHAkB2X4TtH4qXjZivnsJqwcF4FchNZ7FVuKyRzuJE5hD+7ys7eeqJ6x3p8Y9dKMDfr84Mz7uGVDGCwjpj5oCZ+fg+");
        RSAPublicKey publicKey = RSAUtils.getPublicKeyFromString("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrxtDVRmRc6kh6kdGo/qJkRADX+ZhcK+a63NuCgSK26Z9Cw4mASwJXB4vLu9wKKnF3yJ2r3jbbRMdJCvM4VlwJkYKAL0FsimTPcYOHFT0AKwXbn4drsJRuQ1IviZ+MfhdSUTxh+N4YuaAkJoTTGY3Om59XTnV91F/KU4Lp6yA+WQIDAQAB");
        long startTime = System.currentTimeMillis();
        String c1 = RSAUtils.encryptByPrivate("password".getBytes(),privateKey);
        System.out.println(c1);
        String password = RSAUtils.decryptByPublic(c1,publicKey);
        long endTime = System.currentTimeMillis();
        System.out.println(password);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
