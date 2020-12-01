package hbv.com.ua.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertiesUtil {
    private static ApplicationPropertiesUtil instance;

    private Properties properties;
    private String propertyName;

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    private ApplicationPropertiesUtil() {}

    private void init() {
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertyName)) {
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
