package tests;

import com.codeborne.selenide.Configuration;
import config.SecretsConfig;
import drivers.BrowserstackMobileDriver;
import drivers.EmulatorMobileDriver;
import drivers.SelenoidMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;

public class TestBase {

    public static SecretsConfig secretsConfig = ConfigFactory.create(SecretsConfig.class);


    @BeforeAll
    public static void setUp() {
        addListener("AllureSelenide", new AllureSelenide());

        String host = System.getProperty("host");
        if (host == null) {
            throw new RuntimeException("Platform type not selected");
        } else if (host.equals("emulator")) {
            Configuration.browser = EmulatorMobileDriver.class.getName();
        } else if (host.equals("browserstack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else if (host.equals("selenoid")) {
            Configuration.browser = SelenoidMobileDriver.class.getName();
        }

        Configuration.startMaximized = true;
        Configuration.browserSize = null;
        Configuration.timeout = 100000;

    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
//        String sessionId = getSessionId();
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        if (System.getProperty("host").equals("browserstack")) {
//            Attach.attachVideo(sessionId);
//        }
        closeWebDriver();
    }

}
