package hbv.com.ua.action.impl;

import hbv.com.ua.action.AbstractParametrizedParametrizedActionService;
import hbv.com.ua.domain.UserDomain;
import hbv.com.ua.service.mybatis.impl.UserAsyncMybatisService;
import io.undertow.server.HttpServerExchange;
import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.Map;

@Scope("singleton")
@Component
public class RegistrationParametrizedActionServiceImpl extends AbstractParametrizedParametrizedActionService {
    private UserAsyncMybatisService userAsyncMybatisService;

    @Autowired
    public void setUserAsyncMybatisService(UserAsyncMybatisService userAsyncMybatisService) {
        this.userAsyncMybatisService = userAsyncMybatisService;
    }


    @Override
    public void execute(HttpServerExchange exchange, Map<String, Deque<String>> parameters, JSONObject jsonObject) {
        this.userAsyncMybatisService.create(new ModelMapper().map(jsonObject, UserDomain.class));
    }
}
