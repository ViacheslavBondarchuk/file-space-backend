package hbv.com.ua.action;

import hbv.com.ua.util.HttpExchangeUtil;
import io.undertow.server.HttpServerExchange;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractParametrizedParametrizedActionService implements ParametrizedActionService {

    @Override
    public void handle(HttpServerExchange httpServerExchange) throws ParseException {
        AtomicReference<String> body = new AtomicReference<>("{}");
        httpServerExchange.getRequestReceiver().receiveFullString((exchange, message) -> body.set(message));
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(body.get());

        this.execute(httpServerExchange, HttpExchangeUtil.getAllRequestParameters(httpServerExchange), jsonObject);
        this.closeConnection(httpServerExchange);
    }

    @Override
    public void closeConnection(HttpServerExchange httpServerExchange) {
        httpServerExchange.endExchange();
    }
}
