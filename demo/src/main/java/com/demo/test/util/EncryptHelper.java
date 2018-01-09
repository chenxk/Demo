//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.demo.test.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptHelper {

    public static String md5(String str) {
        if(str == null) {
            return null;
        } else {
            try {
                MessageDigest e = MessageDigest.getInstance("MD5");
                e.update(str.getBytes(), 0, str.length());
                String hashedPass = (new BigInteger(1, e.digest())).toString(16);
                if(hashedPass.length() < 32) {
                    hashedPass = "0" + hashedPass;
                }

                return hashedPass.toUpperCase();
            } catch (NoSuchAlgorithmException var3) {
                return null;
            }
        }
    }
}
