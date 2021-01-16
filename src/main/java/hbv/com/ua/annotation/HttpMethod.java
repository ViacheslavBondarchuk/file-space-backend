package hbv.com.ua.annotation;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HttpMethod {
    HttpMethodType type() default HttpMethodType.GET;

    enum HttpMethodType {
        GET, POST, PUT, PATCH, DELETE
    }
}
