package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHolder {

    public static final Properties PROPS;

    static {
        PROPS = new Properties();
        try {
            PROPS.load(new FileInputStream("src/test/resources/userData.properties"));
        } catch (IOException badEvent) {
            System.out.println("Can't load properties file!");
            badEvent.printStackTrace();
        }
    }

    public static Properties getProps() {
        return PROPS;
    }

}
