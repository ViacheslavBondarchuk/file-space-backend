package hbv.com.ua.action;

import io.undertow.server.HttpServerExchange;

public interface ActionService {
    void handle(HttpServerExchange httpServerExchange);
}
