package hbv.com.ua.repository.mybatis.impl;

import hbv.com.ua.domain.UserDomain;
import hbv.com.ua.repository.mybatis.CRUD;

import java.util.Optional;

public interface UserRepository extends CRUD<UserDomain, Long> {

    Optional<UserDomain> findByUsername(final String username);

    Optional<UserDomain> findByEmail(final String email);

    Optional<UserDomain> findByPhone(final String phone);
}
