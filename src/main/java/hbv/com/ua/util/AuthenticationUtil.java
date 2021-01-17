package hbv.com.ua.util;

import hbv.com.ua.security.authentication.Oauth2MechanismImpl;
import io.undertow.security.api.AuthenticationMechanism;

public class AuthenticationUtil {
    private static AuthenticationUtil instance;
    private AuthenticationMechanism authenticationMechanism;

    public AuthenticationMechanism getAuthenticationMechanism() {
        return authenticationMechanism;
    }

    public AuthenticationUtil() {
        this.init();
    }

    private void init() {
        authenticationMechanism = new Oauth2MechanismImpl();
    }

    public static AuthenticationUtil getInstance() {
        if (instance == null) {
            synchronized (AuthenticationUtil.class) {
                if (instance == null) {
                    instance = new AuthenticationUtil();
                }
            }
        }
        return instance;
    }

    public static void authenticate() {

    }
}
