package hbv.com.ua.util;

import io.undertow.server.HttpServerExchange;

import java.util.Deque;
import java.util.Map;
import java.util.Optional;

public class HttpExchangeUtil {

    public static String getRequestParameter(final HttpServerExchange exchange, final String parameter) {
        return Optional.of(exchange.getQueryParameters().get(parameter))
                .orElseThrow(() -> new RuntimeException(String.format("Request parameter %s has been not found", parameter)))
                .getFirst();
    }

    public static String getPathParameter(final HttpServerExchange exchange, final String parameter) {
        return Optional.of(exchange.getPathParameters().get(parameter))
                .orElseThrow(() -> new RuntimeException(String.format("Path parameter %s has been not found", parameter))).getFirst();
    }

    public static Map<String, Deque<String>> getAllRequestParameters(final HttpServerExchange exchange) {
        return exchange.getQueryParameters();
    }

    public static Map<String, Deque<String>> getAllPathParameters(final HttpServerExchange exchange) {
        return exchange.getPathParameters();
    }
}
