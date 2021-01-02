package hbv.com.ua.container;

import hbv.com.ua.annotation.HttpController;
import hbv.com.ua.util.ApplicationPropertiesUtil;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetAddress;
import java.util.List;

public class UndertowContainer {
    private Undertow undertow;
    private List<HttpHandler> httpHandlers;

    private final String PORT = ApplicationPropertiesUtil.getInstance().getProperty("application.port");

    @Autowired
    public void setHttpHandlers(List<HttpHandler> httpHandlers) {
        this.httpHandlers = httpHandlers;
    }

    protected void init() {
        PathHandler pathHandler = new PathHandler();

        httpHandlers.forEach(httpHandler -> {
            HttpController annotation = httpHandler.getClass().getAnnotation(HttpController.class);
            pathHandler.addExactPath(annotation.path(), httpHandler);
        });

        undertow = Undertow.builder()
                .addHttpListener(Integer.parseInt(PORT), InetAddress.getLoopbackAddress().getHostAddress())
                .setHandler(pathHandler)
                .build();
        undertow.start();
    }

    protected void destroy() {
        if (undertow != null)
            undertow.stop();
    }
}
