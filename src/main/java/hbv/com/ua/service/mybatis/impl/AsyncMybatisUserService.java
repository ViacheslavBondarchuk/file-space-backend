package hbv.com.ua.service.mybatis.impl;

import hbv.com.ua.model.Authority;
import hbv.com.ua.model.User;
import hbv.com.ua.repository.mybatis.impl.UserRepository;
import hbv.com.ua.service.mybatis.AbstractAsyncMybatisService;
import hbv.com.ua.util.BCryptUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class AsyncMybatisUserService extends AbstractAsyncMybatisService<User, Long, UserRepository> {
    public AsyncMybatisUserService(UserRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public void create(User user) {
        user.setPassword(BCryptUtil.encode(user.getPassword()));
        user.setEnabled(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAuthorities(Collections.singleton(Authority.USER));

        super.create(user);
    }
}
