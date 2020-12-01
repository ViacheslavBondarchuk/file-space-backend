package hbv.com.ua;

import hbv.com.ua.constant.Constants;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext(Constants.Application.APPLICATION_CONTEXT_PATH);
    }
}
