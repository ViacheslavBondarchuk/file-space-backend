package hbv.com.ua.container;

import hbv.com.ua.action.ActionServiceFactory;
import hbv.com.ua.util.ApplicationPropertiesUtil;
import hbv.com.ua.util.HttpExchangeUtil;
import io.undertow.Undertow;

public class UndertowContainer {
    private final String ACTION_PARAMETER = "action";

    private final String HOST = ApplicationPropertiesUtil.getInstance().getProperty("application.host");
    private final String PORT = ApplicationPropertiesUtil.getInstance().getProperty("application.port");

    private Undertow undertow;

    protected void init() {
        undertow = Undertow.builder()
                .addHttpListener(Integer.parseInt(PORT), HOST)
                .setHandler(httpServerExchange -> {
                    ActionServiceFactory
                            .getActionService(HttpExchangeUtil.getRequestParameter(httpServerExchange, ACTION_PARAMETER))
                            .handle(httpServerExchange);
                }).build();
        undertow.start();
    }

    protected void destroy() {
        if (undertow != null)
            undertow.stop();
    }
}
