package helpers;

import com.codeborne.selenide.Configuration;
import config.BrowserstackConfig;
import config.EmulatorConfig;
import config.RealDeviceConfig;
import config.SelenoidConfig;
import drivers.BrowserstackMobileDriver;
import drivers.EmulatorMobileDriver;
import drivers.SelenoidMobileDriver;
import org.aeonbits.owner.ConfigFactory;

public class ConfigSettings {

    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);
    public static EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class);
    public static RealDeviceConfig realDeviceConfig = ConfigFactory.create(RealDeviceConfig.class);
    public static SelenoidConfig selenoidConfig = ConfigFactory.create(SelenoidConfig.class);

    public static void setBrowser() {
        String host = System.getProperty("host");
        if (host.equals("emulator")) {
            Configuration.browser = EmulatorMobileDriver.class.getName();
        } else if (host.equals("browserstack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else if (host.equals("selenoid")) {
            Configuration.browser = SelenoidMobileDriver.class.getName();
        }

    }


}
