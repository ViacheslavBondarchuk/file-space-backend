package hbv.com.ua.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertiesUtil {
    private static ApplicationPropertiesUtil instance;

    private Properties properties;

    private String PROPERTIES_PATH = "properties/application.properties";

    public ApplicationPropertiesUtil() {
        this.init();
    }

    private void init() {
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_PATH)) {
            this.properties = new Properties();
            this.properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ApplicationPropertiesUtil getInstance() {
        if (instance == null)
            instance = new ApplicationPropertiesUtil();
        return instance;
    }

    public String getProperty(final String key) {
        return this.properties.getProperty(key);
    }

    public String getProperty(final String key, final String defaultValue) {
        return (String) this.properties.getOrDefault(key, defaultValue);
    }

}
