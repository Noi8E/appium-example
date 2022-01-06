package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.config;

public class ConfigSettings {

    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class,System.getProperties());
    public static DevicesConfig devicesConfig = ConfigFactory.create(DevicesConfig.class,System.getProperties());

    public static void setConfig() {
        String user = browserstackConfig.getUser();
        String key = browserstackConfig.getKey();
    }


}
