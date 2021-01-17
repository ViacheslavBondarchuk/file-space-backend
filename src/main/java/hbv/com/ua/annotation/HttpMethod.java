package hbv.com.ua.annotation;

import hbv.com.ua.model.Authority;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HttpMethod {
    HttpMethodType type() default HttpMethodType.GET;

    Authority[] authority() default {Authority.USER};

    boolean requireAuthenticate() default true;

    enum HttpMethodType {
        GET, POST, PUT, PATCH, DELETE
    }
}
