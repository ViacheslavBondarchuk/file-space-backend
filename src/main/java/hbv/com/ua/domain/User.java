package hbv.com.ua.domain;

public class User {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public static Builder builder() {
        return new User().new Builder();
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

    public class Builder {

        protected Builder setId(final Long id) {
            User.this.setId(id);
            return this;
        }

        protected Builder setUsername(final String username) {
            User.this.setUsername(username);
            return this;
        }

        protected Builder setFirstname(final String firstname) {
            User.this.setFirstname(firstname);
            return this;
        }

        protected Builder setLastname(final String lastname) {
            User.this.setLastname(lastname);
            return this;
        }

        protected Builder setEmail(final String email) {
            User.this.setEmail(email);
            return this;
        }

        protected Builder setPhone(final String phone) {
            User.this.setPhone(phone);
            return this;
        }

        protected User build(){
            return User.this;
        }
    }

}
