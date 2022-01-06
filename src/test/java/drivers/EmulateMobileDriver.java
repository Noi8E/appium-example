package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulatorConfig;
import config.RealDeviceConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static drivers.RealMobileDriver.getAppiumUrl;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EmulateMobileDriver implements WebDriverProvider {

    static EmulatorConfig emulatorConfig  = ConfigFactory.create(EmulatorConfig.class, System.getProperties());

    static String url = emulatorConfig.url();
    static String platformName = emulatorConfig.platformName();
    static String deviceName = emulatorConfig.deviceName();
    static String version = emulatorConfig.version();
    static String locale = emulatorConfig.locale();
    static String language = emulatorConfig.language();
    static String appPackage = emulatorConfig.appPackage();
    static String appActivity = emulatorConfig.appActivity();

    public static URL getAppiumServerUrl() {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName",platformName);
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("version", version);
        desiredCapabilities.setCapability("locale", locale);
        desiredCapabilities.setCapability("language", language);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("app", getAbsolutePath("src/test/resources/app-alpha-universal-release.apk"));


        return new AndroidDriver(getAppiumUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}
