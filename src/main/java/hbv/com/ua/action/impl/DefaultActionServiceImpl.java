package hbv.com.ua.action.impl;

import hbv.com.ua.action.ActionService;
import io.undertow.server.HttpServerExchange;
import org.springframework.beans.factory.annotation.Value;

public class DefaultActionServiceImpl implements ActionService {
    @Value("${action.service.default.message}")
    private String message;

    @Override
    public void handle(HttpServerExchange httpServerExchange) {
        httpServerExchange.getResponseSender()
                .send(message);
    }
}
