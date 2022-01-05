package tests;


import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("Selenide Android")
public class AndroidSelenideTests extends TestBase {
    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Harry Potter");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Test with Owner")
    void evaluateResults() {
        step("Search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Har");
        });
        step("evaluate search results on main page", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/horizontal_scroll_list_item_image")).shouldBe(visible);
        });

        step("evaluate valid result", () -> {

            $(MobileBy.id("org.wikipedia.alpha:id/horizontal_scroll_list_item_image")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/view_page_title_text")).isDisplayed();

        });
    }

}
