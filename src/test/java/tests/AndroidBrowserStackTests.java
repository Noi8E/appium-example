package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("browserstack_android")
public class AndroidBrowserStackTests extends TestBase {
    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        back();
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Harry Potter");
            $(MobileBy.id("org.wikipedia.alpha:id/search_close_btn")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("DIE HARD");
        });

        step("Open first search result", () -> {
            $x("//*[@text='Die Hard']").contextClick();
            $x("//*[@text='Open']").click();

        });

        step("Tap to Actors link", () -> {
            $x("//*[@text='Alan Rickman']").click();
        });

        step("check preview", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/link_preview_extract")).shouldBe(visible);
        });
    }
    @Test
    @DisplayName("Can edit language settings")
    void editLanguageTest() {
        step("can Add Language", () -> {
            $x("//*[@text='ADD OR EDIT LANGUAGES']").click();
            $x("//*[@text='ADD LANGUAGE']").click();
            $x("//*[@text='Русский']").click();
        });
        step("A language is added", () -> {
            $x("//*[@text='RU']").shouldBe(visible);
        });
        step("Can deleted some language set", () -> {
            $x("//*[@content-desc='More options']").click();
            $(MobileBy.id("org.wikipedia.alpha:id/title")).click();
            $x("//*[@text='RU']").click();
            $(MobileBy.id("org.wikipedia.alpha:id/menu_delete_selected")).click();
            $(MobileBy.id("android:id/button1")).click();
        });
        step("check succesfully deleted language item", () -> {
            $x("//*[@text='RU']").shouldNot(visible);
        });
    }
}
