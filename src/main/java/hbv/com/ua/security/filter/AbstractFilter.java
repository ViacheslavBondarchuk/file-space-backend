package hbv.com.ua.security.filter;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public abstract class AbstractFilter implements HttpHandler {
    private final HttpHandler next;

    public AbstractFilter(HttpHandler next) {
        this.next = next;
    }

    protected void next(HttpServerExchange httpServerExchange) throws Exception {
        if (next != null) {
            next.handleRequest(httpServerExchange);
        }
    }
}
