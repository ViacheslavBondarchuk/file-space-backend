package hbv.com.ua.action.impl;

import hbv.com.ua.action.ActionService;
import io.undertow.server.HttpServerExchange;
import org.springframework.beans.factory.annotation.Value;

public class DefaultActionServiceImpl implements ActionService {

    @Override
    public void handle(HttpServerExchange httpServerExchange) {
        httpServerExchange.getResponseSender()
                .send("action service has not been found, please, correct your action");
    }
}
