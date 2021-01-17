package hbv.com.ua.util;

import at.favre.lib.crypto.bcrypt.BCrypt;
import hbv.com.ua.exception.authentication.PasswordIncorrectException;

import java.nio.charset.StandardCharsets;

public class BCryptUtil {

    public static String encode(String password) {
        return new String(BCrypt.withDefaults().hash(BCrypt.MIN_COST, password.toCharArray()));
    }

    public static void verify(String password, String bCryptHash) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bCryptHash.getBytes(StandardCharsets.UTF_8));
        if (!result.validFormat) throw new PasswordIncorrectException("Password hash is`nt instance of bCrypt");
    }

    public static boolean compareBCryptHash(String bCryptHash1, String bCryptHash2) {
        return bCryptHash1.equals(bCryptHash2);
    }

}
