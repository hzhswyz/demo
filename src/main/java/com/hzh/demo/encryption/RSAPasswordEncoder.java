package com.hzh.demo.encryption;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSAPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        System.out.println("encode CharSequence："+charSequence);
        String password = "";
        if(charSequence!=null){
            RSAPrivateKey privateKey = RSAUtils.getPrivateKeyFromString("MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKvG0NVGZFzqSHqR0aj+omREANf5mFwr5rrc24KBIrbpn0LDiYBLAlcHi8u73AoqcXfInaveNttEx0kK8zhWXAmRgoAvQWyKZM9xg4cVPQArBdufh2uwlG5DUi+Jn4x+F1JRPGH43hi5oCQmhNMZjc6bn1dOdX3UX8pTgunrID5ZAgMBAAECgYAff1Axmzux8d+iYfSQyUgbnICPGZw/YmlnYDH75xPneEUUp+ghlx9xt9eBXwwE7S1rKmUG67MhV6Y3FYPtk6BCb+5+tRDntWE7tveUBJtn2qhmunz41DPmoqp57twuIk4m4712gl2fmnSQdoCpIyy6tGyTSe9OQpbjnthL/DV6dQJBANoUt3fYJ4txKWztajNlslb0RlxMhtITN1w11Gg7Cw9QpxC2qH3niAV1XThEld3d9bHct4+sSLWf5sNY7WBWfUcCQQDJpPz7gRzP5PKDZdcW0B1ylHuSyEwvjDXYyuwtK7uZ7h5FIzwX9u2VdzbrgAzALI785+Orjs+4JoBx+q0BtrdfAkBw9W4au3GwPoswisEJolF/zMNtJ45l3eI89vzwiDSwWBxRAevAW18PRL1mWdAuvbt3x1WlK531xb9ny/YYgnQdAkBycqd35E9DG/IdbBcJhrPADdCZff/n2M/TLVGhTbob4w/hM99uxqMQe2p7feE+zcuWddM90z/IiGnMx3ecimVHAkB2X4TtH4qXjZivnsJqwcF4FchNZ7FVuKyRzuJE5hD+7ys7eeqJ6x3p8Y9dKMDfr84Mz7uGVDGCwjpj5oCZ+fg+");
            password = RSAUtils.decryptByPrivate(charSequence.toString(),privateKey);
            System.out.println("保存在数据库中的加密密码："+password);
        }
        return password;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        if(s!=null) {
            System.out.println("receive password：" + charSequence);
            System.out.println("database text：" + s);
            RSAPublicKey publicKey = RSAUtils.getPublicKeyFromString("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrxtDVRmRc6kh6kdGo/qJkRADX+ZhcK+a63NuCgSK26Z9Cw4mASwJXB4vLu9wKKnF3yJ2r3jbbRMdJCvM4VlwJkYKAL0FsimTPcYOHFT0AKwXbn4drsJRuQ1IviZ+MfhdSUTxh+N4YuaAkJoTTGY3Om59XTnV91F/KU4Lp6yA+WQIDAQAB");
            String password = RSAUtils.decryptByPublic(s, publicKey);
            System.out.println("real password:"+password);
            if (charSequence.toString().equals(password))
                return true;
            else
                return false;
        }
        return false;
    }
}
