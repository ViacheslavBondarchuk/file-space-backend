package hbv.com.ua;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:context/application-context.xml");
    }
}
