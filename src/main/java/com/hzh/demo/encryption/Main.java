package com.hzh.demo.encryption;

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

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");*/

       String[] strings = RSAUtils.getKeyPair();
        System.out.println(strings[0]);
        System.out.println(strings[1]);
    }
}
