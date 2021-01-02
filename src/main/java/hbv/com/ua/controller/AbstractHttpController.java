package hbv.com.ua.controller;

import hbv.com.ua.annotation.HttpMethod;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractHttpController implements HttpHandler {

    @Override
    public final void handleRequest(HttpServerExchange httpServerExchange) throws Exception {
        String requestHttpMethodType = String.valueOf(httpServerExchange.getRequestMethod()).toUpperCase();

        List<Method> methods = Arrays.stream(this.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(HttpMethod.class))
                .collect(Collectors.toList());

        System.out.println();

        for (Method method : methods) {
            String methodType = method.getAnnotation(HttpMethod.class)
                    .type()
                    .toString()
                    .toUpperCase();

            if (requestHttpMethodType.equals(methodType)) {
                method.invoke(this, httpServerExchange);
            }

        }

    }
}
