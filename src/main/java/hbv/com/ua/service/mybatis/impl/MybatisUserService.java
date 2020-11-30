package hbv.com.ua.service.mybatis.impl;

import hbv.com.ua.domain.User;
import hbv.com.ua.repository.mybatis.impl.UserRepository;
import hbv.com.ua.service.mybatis.AbstractMybatisService;

public class MybatisUserService extends AbstractMybatisService<User, Long, UserRepository> {
    public MybatisUserService(UserRepository repository) {
        super(repository);
    }
}
