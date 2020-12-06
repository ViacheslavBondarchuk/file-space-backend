package hbv.com.ua.action.impl;

import hbv.com.ua.action.AbstractParametrizedParametrizedActionService;
import hbv.com.ua.action.ParametrizedActionService;
import io.undertow.server.HttpServerExchange;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.Map;

@Component
public class CreateParametrizedActionServiceImpl extends AbstractParametrizedParametrizedActionService {

    @Override
    public void execute(HttpServerExchange exchange, Map<String, Deque<String>> parameters, JSONObject jsonObject) {

    }
}
