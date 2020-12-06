package hbv.com.ua.service.mybatis.impl;

import hbv.com.ua.domain.Authority;
import hbv.com.ua.domain.UserDomain;
import hbv.com.ua.repository.mybatis.impl.UserRepository;
import hbv.com.ua.service.mybatis.AbstractAsyncMybatisService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class UserAsyncMybatisService extends AbstractAsyncMybatisService<UserDomain, Long, UserRepository> implements UserDetailsService {
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setBCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserAsyncMybatisService(UserRepository repository) {
        super(repository);
    }

    @Override
    public void create(UserDomain userDomain) {
        super.create(this.makeUser(userDomain));
    }

    @Override
    public UserDomain update(UserDomain userDomain, Long aLong) throws InterruptedException, ExecutionException, NotFoundException {
        return super.update(userDomain, aLong);
    }

    @Override
    public UserDomain read(Long aLong) throws InterruptedException, ExecutionException, NotFoundException {
        return super.read(aLong);
    }

    @Override
    public void delete(Long aLong) {
        super.delete(aLong);
    }

    private UserDomain makeUser(UserDomain userDomain) {
        userDomain.setPassword(bCryptPasswordEncoder.encode(userDomain.getPassword()));
        userDomain.setEnabled(true);
        userDomain.setAccountNonLocked(true);
        userDomain.setAccountNonExpired(true);
        userDomain.setCredentialsNonExpired(true);
        userDomain.setAuthority(Authority.USER);

        return userDomain;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User by username %s has been not found", username)));
    }
}
