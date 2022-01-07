package drivers;

import com.codeborne.selenide.WebDriverProvider;
import helpers.ConfigSettings;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver extends ConfigSettings implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL(browserstackConfig.hostName());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", browserstackConfig.user());
        desiredCapabilities.setCapability("browserstack.key", browserstackConfig.key());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", browserstackConfig.app());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", browserstackConfig.device());
        desiredCapabilities.setCapability("os_version", browserstackConfig.osVersion());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }


}