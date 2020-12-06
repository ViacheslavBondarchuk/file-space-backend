package hbv.com.ua.container;

import hbv.com.ua.action.ActionServiceFactory;
import hbv.com.ua.util.ApplicationPropertiesUtil;
import hbv.com.ua.util.HttpExchangeUtil;
import io.undertow.Undertow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class UndertowContainer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String ACTION_PARAMETER = "action";
    private final String HOST = ApplicationPropertiesUtil.getInstance().getProperty("application.host");
    private final String PORT = ApplicationPropertiesUtil.getInstance().getProperty("application.port");
    private final String USE_PROXY = ApplicationPropertiesUtil.getInstance().getProperty("application.useProxy");

    private Undertow undertow;

    protected void init() throws UnknownHostException {
        logger.info("Undertow began start");

        Undertow.ListenerBuilder listenerBuilder = new Undertow.ListenerBuilder()
                .setHost(InetAddress.getLocalHost().getHostAddress())
                .setPort(Integer.parseInt(PORT))
                .setType(Undertow.ListenerType.HTTP)
                .setUseProxyProtocol(Boolean.parseBoolean(USE_PROXY));

        undertow = Undertow.builder()
                .addListener(listenerBuilder)
                .setHandler(httpServerExchange -> {
                    ActionServiceFactory
                            .getInstance()
                            .getActionService(HttpExchangeUtil.getRequestParameter(httpServerExchange, ACTION_PARAMETER))
                            .handle(httpServerExchange);
                }).build();
        undertow.start();

        logger.info(String.format("Undertow started on %s:%s", InetAddress.getLocalHost().getHostAddress(), PORT));
    }

    protected void destroy() {
        if (undertow != null)
            undertow.stop();
    }
}
