package hbv.com.ua.repository.mybatis.impl;

import hbv.com.ua.model.User;
import hbv.com.ua.repository.mybatis.CRUD;

import java.util.Optional;

public interface UserRepository extends CRUD<User, Long> {

    Optional<User> findByUsername(final String username);

    Optional<User> findByEmail(final String email);

    Optional<User> findByPhone(final String phone);
}
