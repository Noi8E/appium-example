package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.RealDeviceConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RealMobileDriver implements WebDriverProvider {

    static RealDeviceConfig realDeviceConfig = ConfigFactory.create(RealDeviceConfig.class,System.getProperties());

    static String url = realDeviceConfig.url();
    static String platform = realDeviceConfig.platformName();
    static String deviceName = realDeviceConfig.deviceName();
    static String version = realDeviceConfig.version();
    static String locale = realDeviceConfig.locale();
    static String language = realDeviceConfig.language();
    static String appPackage = realDeviceConfig.appPackage();
    static String appActivity = realDeviceConfig.appActivity();


    public static URL getAppiumUrl() {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {


        // Specify device and os_version for testing
        desiredCapabilities.setCapability("platformName",platform);
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("version", version);
        desiredCapabilities.setCapability("locale", locale);
        desiredCapabilities.setCapability("language", language);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("app",getAbsolutePath("src/test/resources/app-alpha-universal-release.apk"));

        return new AndroidDriver(getAppiumUrl(), desiredCapabilities);
    }
    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");
        return file.getAbsolutePath();
    }
}