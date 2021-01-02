package hbv.com.ua.service.mybatis.impl;

import hbv.com.ua.domain.Authority;
import hbv.com.ua.domain.UserDomain;
import hbv.com.ua.repository.mybatis.impl.UserRepository;
import hbv.com.ua.service.mybatis.AbstractMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MybatisUserService extends AbstractMybatisService<UserDomain, Long, UserRepository> implements UserDetailsService {
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public MybatisUserService(UserRepository repository) {
        super(repository);
    }

    public MybatisUserService() {
    }

    @Override
    public void create(UserDomain userDomain) {
        userDomain.setPassword(bCryptPasswordEncoder.encode(userDomain.getPassword()));
        userDomain.setEnabled(true);
        userDomain.setAccountNonLocked(true);
        userDomain.setAccountNonExpired(true);
        userDomain.setCredentialsNonExpired(true);
        userDomain.setAuthorities(Collections.singleton(Authority.USER));

        super.create(userDomain);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                                String.format("user by username: %s has been not found", username)
                        )
                );
    }
}
