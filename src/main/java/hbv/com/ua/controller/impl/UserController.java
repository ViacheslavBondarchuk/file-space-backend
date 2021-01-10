package hbv.com.ua.controller.impl;

import hbv.com.ua.annotation.HttpController;
import hbv.com.ua.annotation.HttpMethod;
import hbv.com.ua.controller.AbstractHttpController;
import hbv.com.ua.domain.UserDomain;
import hbv.com.ua.service.mybatis.impl.MybatisUserService;
import hbv.com.ua.util.HttpExchangeUtil;
import io.undertow.server.HttpServerExchange;
import org.springframework.beans.factory.annotation.Autowired;

@HttpController( path = "/users" )
public class UserController extends AbstractHttpController {
	private MybatisUserService mybatisUserService;

	@Autowired
	public void setMybatisUserService( MybatisUserService mybatisUserService ) {
		this.mybatisUserService = mybatisUserService;
	}

	@HttpMethod( type = HttpMethod.HttpMethodType.POST )
	public void create( HttpServerExchange httpServerExchange ) {
		mybatisUserService.create( HttpExchangeUtil.getFormBody( httpServerExchange, UserDomain.class ) );
	}
}
