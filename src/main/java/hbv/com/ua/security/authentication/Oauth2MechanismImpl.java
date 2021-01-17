package hbv.com.ua.security.authentication;

import io.undertow.security.api.AuthenticationMechanism;
import io.undertow.security.api.SecurityContext;
import io.undertow.server.HttpServerExchange;

public class Oauth2MechanismImpl implements AuthenticationMechanism {
    @Override
    public AuthenticationMechanismOutcome authenticate(HttpServerExchange httpServerExchange, SecurityContext securityContext) {
        return null;
    }

    @Override
    public ChallengeResult sendChallenge(HttpServerExchange httpServerExchange, SecurityContext securityContext) {
        return null;
    }
}
