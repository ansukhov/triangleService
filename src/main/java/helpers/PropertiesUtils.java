package helpers;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {

    private static final String CONFIG_PATH = "src/main/resources/main.properties";

    public static String getProperty(String propertyName) {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) {
            property.load(fis);
            return property.getProperty(propertyName);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Can't find property with name: %s", propertyName));
        }
    }
}
