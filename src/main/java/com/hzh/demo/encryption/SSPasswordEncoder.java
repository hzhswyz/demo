package com.hzh.demo.encryption;

import org.springframework.security.crypto.password.PasswordEncoder;

public class SSPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        RSAUtils.getPublicKeyFromString("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDK1UzG/p7oFU+jRkEuYBfTCswyQVNvPDCtq139Po6B6V4xRrlU0/2bkmoceQqo9u4oPDSLi+TGGVEtHYixUlZNAzp9LIU+0mmPOuXGnd4l5BbZH9tYUE07BG6v+uPg3NkekuUpOba+ZRVomQ59BHhvStliOfvUS91Sc7ELUyIbkwIDAQAB");

        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }
}
