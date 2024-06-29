package ru.karpunin.t1simpleapp.util;

import java.util.Base64;

public class Base64Encoder {
    public static String encodeBase64EmailAndCode(String email, String code) {

        if(email == null || code == null) {
            throw new RuntimeException("Code or email is null!!");
        }

        return new String(Base64.getEncoder().encode("%s:%s".formatted(email, code).getBytes()));
    }
}
