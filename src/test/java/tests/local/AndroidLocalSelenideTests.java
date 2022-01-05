package tests.local;


import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("Selenide Android")
public class AndroidLocalSelenideTests extends LocalTestBase {
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

//                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
//                        .shouldHave(sizeGreaterThan(0))

}
