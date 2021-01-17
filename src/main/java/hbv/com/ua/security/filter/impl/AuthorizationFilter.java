package hbv.com.ua.security.filter.impl;

import hbv.com.ua.security.filter.AbstractFilter;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class AuthorizationFilter extends AbstractFilter {

    public AuthorizationFilter(HttpHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(HttpServerExchange httpServerExchange) throws Exception {
        super.next(httpServerExchange);
    }
}
