package hbv.com.ua.controller.impl;

import hbv.com.ua.annotation.HttpController;
import hbv.com.ua.annotation.HttpMethod;
import hbv.com.ua.controller.AbstractHttpController;
import io.undertow.server.HttpServerExchange;

@HttpController(path = "/login")
public class LoginController extends AbstractHttpController {

    @HttpMethod(type = HttpMethod.HttpMethodType.POST, requireAuthenticate = false)
    public void login(HttpServerExchange httpServerExchange) {

    }


}
