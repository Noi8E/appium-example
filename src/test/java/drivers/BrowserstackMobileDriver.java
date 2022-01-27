package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

import static tests.TestBase.secretsConfig;

public class BrowserstackMobileDriver implements WebDriverProvider {


    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", secretsConfig.browserstackUser());
        desiredCapabilities.setCapability("browserstack.key", secretsConfig.browserstackKey());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", secretsConfig.browserstackApp());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", "Google Pixel 4");
        desiredCapabilities.setCapability("os_version", "11.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "QA GURU SAMPLE");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "qa-guru-sample-tests");

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }


}