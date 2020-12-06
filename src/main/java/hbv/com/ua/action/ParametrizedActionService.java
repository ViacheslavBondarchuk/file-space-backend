package hbv.com.ua.action;

import io.undertow.server.HttpServerExchange;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.Deque;
import java.util.Map;

public interface ParametrizedActionService {
    void handle(HttpServerExchange httpServerExchange) throws ParseException;

    void execute(HttpServerExchange exchange, Map<String, Deque<String>> parameters, JSONObject jsonObject);

    void closeConnection(HttpServerExchange httpServerExchange);
}
