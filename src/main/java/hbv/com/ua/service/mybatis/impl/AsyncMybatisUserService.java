package hbv.com.ua.service.mybatis.impl;

import hbv.com.ua.model.Authority;
import hbv.com.ua.model.User;
import hbv.com.ua.repository.mybatis.impl.UserRepository;
import hbv.com.ua.service.mybatis.AbstractAsyncMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class AsyncMybatisUserService extends AbstractAsyncMybatisService<User, Long, UserRepository > implements UserDetailsService {
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public void setbCryptPasswordEncoder( BCryptPasswordEncoder bCryptPasswordEncoder ) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public AsyncMybatisUserService( UserRepository repository ) {
		super( repository );
	}

	@Override
	@Transactional
	public void create( User user) {
		user.setPassword( bCryptPasswordEncoder.encode( user.getPassword( ) ) );
		user.setEnabled( true );
		user.setAccountNonLocked( true );
		user.setAccountNonExpired( true );
		user.setCredentialsNonExpired( true );
		user.setAuthorities( Collections.singleton( Authority.USER ) );

		super.create(user);
	}

	@Override
	public UserDetails loadUserByUsername( final String username ) throws UsernameNotFoundException {
		return repository.findByUsername( username )
				.orElseThrow( ( ) -> new UsernameNotFoundException(
								String.format( "user by username: %s has been not found", username )
						)
				);
	}
}
