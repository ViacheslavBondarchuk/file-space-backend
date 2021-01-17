package hbv.com.ua.security.filter.impl;

import hbv.com.ua.security.filter.AbstractFilter;
import io.undertow.security.api.SecurityContext;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class AuthenticationFilter extends AbstractFilter {
    public AuthenticationFilter(HttpHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(HttpServerExchange httpServerExchange) throws Exception {
        SecurityContext securityContext = httpServerExchange.getSecurityContext();
        boolean authenticated = securityContext.isAuthenticated();


        super.next(httpServerExchange);
    }
}
