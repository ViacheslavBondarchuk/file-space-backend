package hbv.com.ua.util;

import hbv.com.ua.domain.UserDomain;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.Collections;

public class AuthenticationUtil {
    private static AuthenticationUtil instance;

    public static AuthenticationUtil getInstance() {
        if (instance == null)
            instance = new AuthenticationUtil();
        return instance;
    }

    public UserDomain getCurrentAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (UserDomain) authentication.getPrincipal();
        }
        return null;
    }

    public Long getCurrentAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return ((UserDomain) authentication.getPrincipal()).getId();
        }
        return null;
    }

    public Collection<? extends GrantedAuthority> getCurrentAuthenticatedUserAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return Collections.unmodifiableCollection(((UserDomain) authentication.getPrincipal()).getAuthorities());
        }
        return Collections.emptySet();
    }


}
