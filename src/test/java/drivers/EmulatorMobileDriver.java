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


public class EmulatorMobileDriver extends ConfigSettings implements WebDriverProvider {

    public static URL getAppiumUrl() {
        try {
            return new URL(emulatorConfig.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", emulatorConfig.platformName());
        desiredCapabilities.setCapability("deviceName", emulatorConfig.deviceName());
        desiredCapabilities.setCapability("version", emulatorConfig.version());
        desiredCapabilities.setCapability("locale", emulatorConfig.locale());
        desiredCapabilities.setCapability("language", emulatorConfig.language());
        desiredCapabilities.setCapability("appPackage", emulatorConfig.appPackage());
        desiredCapabilities.setCapability("appActivity", emulatorConfig.appActivity());
        desiredCapabilities.setCapability("app", getAbsolutePath("src/test/resources/app-alpha-universal-release.apk"));


        return new AndroidDriver(getAppiumUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}
