package hbv.com.ua.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class UserDomain implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    private boolean isEnabled;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;
    private Set<Authority> authorities;

    public static Builder builder() {
        return new UserDomain().new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setAuthority(Authority authority) {
        this.authorities = Collections.singleton(authority);
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public class Builder {

        protected Builder setId(final Long id) {
            UserDomain.this.setId(id);
            return this;
        }

        protected Builder setUsername(final String username) {
            UserDomain.this.setUsername(username);
            return this;
        }

        protected Builder setPassword(final String password) {
            UserDomain.this.setPassword(password);
            return this;
        }

        protected Builder setFirstname(final String firstname) {
            UserDomain.this.setFirstname(firstname);
            return this;
        }

        protected Builder setLastname(final String lastname) {
            UserDomain.this.setLastname(lastname);
            return this;
        }

        protected Builder setEmail(final String email) {
            UserDomain.this.setEmail(email);
            return this;
        }

        protected Builder setPhone(final String phone) {
            UserDomain.this.setPhone(phone);
            return this;
        }

        protected Builder setEnabled(final boolean isEnable) {
            UserDomain.this.setEnabled(isEnable);
            return this;
        }

        protected Builder setAccountNonLocked(final boolean isAccountNonLocked) {
            UserDomain.this.setAccountNonLocked(isAccountNonLocked);
            return this;
        }

        protected Builder setAccountNonExpired(final boolean isAccountNonExpired) {
            UserDomain.this.setAccountNonExpired(isAccountNonExpired);
            return this;
        }

        protected Builder setCredentialsNonExpired(final boolean isCredentialsNonExpired) {
            UserDomain.this.setCredentialsNonExpired(isCredentialsNonExpired);
            return this;
        }

        protected Builder setAuthority(final Authority authority) {
            UserDomain.this.setAuthority(authority);
            return this;
        }

        private Builder setAuthorities(final Set<Authority> authorities){
            UserDomain.this.setAuthorities(authorities);
            return this;
        }

        protected UserDomain build(){
            return UserDomain.this;
        }
    }

}
