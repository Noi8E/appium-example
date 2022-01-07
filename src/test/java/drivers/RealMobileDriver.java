package drivers;

import com.codeborne.selenide.WebDriverProvider;
import helpers.ConfigSettings;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RealMobileDriver extends ConfigSettings implements WebDriverProvider {


    public static URL getAppiumUrl() {
        try {
            return new URL(realDeviceConfig.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {


        // Specify device and os_version for testing
        desiredCapabilities.setCapability("platformName",realDeviceConfig.platformName());
        desiredCapabilities.setCapability("deviceName", realDeviceConfig.deviceName());
        desiredCapabilities.setCapability("version", realDeviceConfig.osVersion());
        desiredCapabilities.setCapability("locale", realDeviceConfig.locale());
        desiredCapabilities.setCapability("language", realDeviceConfig.language());
        desiredCapabilities.setCapability("appPackage", realDeviceConfig.appPackage());
        desiredCapabilities.setCapability("appActivity", realDeviceConfig.appActivity());
        desiredCapabilities.setCapability("app",getAbsolutePath("src/test/resources/app-alpha-universal-release.apk"));

        return new AndroidDriver(getAppiumUrl(), desiredCapabilities);
    }
    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");
        return file.getAbsolutePath();
    }
}