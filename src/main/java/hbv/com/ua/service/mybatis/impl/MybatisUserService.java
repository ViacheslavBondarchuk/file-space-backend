package hbv.com.ua.service.mybatis.impl;

import hbv.com.ua.domain.UserDomain;
import hbv.com.ua.repository.mybatis.impl.UserRepository;
import hbv.com.ua.service.mybatis.AbstractMybatisService;

public class MybatisUserService extends AbstractMybatisService<UserDomain, Long, UserRepository> {
    public MybatisUserService(UserRepository repository) {
        super(repository);
    }
}
