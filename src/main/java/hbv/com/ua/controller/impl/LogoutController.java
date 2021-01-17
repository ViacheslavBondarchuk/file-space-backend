package hbv.com.ua.controller.impl;

import hbv.com.ua.annotation.HttpController;
import hbv.com.ua.annotation.HttpMethod;
import hbv.com.ua.controller.AbstractHttpController;
import hbv.com.ua.model.Authority;
import io.undertow.server.HttpServerExchange;

@HttpController(path = "/logout")
public class LogoutController extends AbstractHttpController {

    @HttpMethod(type = HttpMethod.HttpMethodType.POST, authority = {Authority.ADMIN, Authority.USER})
    public void logout(HttpServerExchange httpServerExchange) {

    }
}
