package hbv.com.ua.controller.impl;

import hbv.com.ua.annotation.HttpController;
import hbv.com.ua.annotation.HttpMethod;
import hbv.com.ua.controller.AbstractHttpController;
import io.undertow.server.HttpServerExchange;

@HttpController(path = "/hello")
public class DriverController extends AbstractHttpController {

    @HttpMethod(type = HttpMethod.HttpMethodType.GET)
    public void get(HttpServerExchange httpServerExchange) {
    }

}
