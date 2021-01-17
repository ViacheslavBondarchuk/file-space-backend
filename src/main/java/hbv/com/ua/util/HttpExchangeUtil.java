package hbv.com.ua.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.form.FormData;
import io.undertow.server.handlers.form.FormDataParser;

import java.util.*;

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

    public static <T> T getFormBody(final HttpServerExchange httpServerExchange, final Class toObject) {
        FormData attachment = httpServerExchange.getAttachment(FormDataParser.FORM_DATA);
        if (attachment != null) {

            Iterator<String> iterator = attachment.iterator();
            Map<String, Object> stringObjectMap = new HashMap<>();
            while (iterator.hasNext()) {
                String key = iterator.next();
                Object value = attachment.get(key).getFirst().getValue();
                stringObjectMap.put(key, value);
            }

            return (T) new ObjectMapper().convertValue(stringObjectMap, toObject);
        }
        return null;
    }
}
