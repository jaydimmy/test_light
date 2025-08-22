package io.testomat.test_light.web.selenide;

import com.codeborne.selenide.SelenideElement;
import io.testomat.test_light.resurses.enums.PageTitles;
import io.testomat.test_light.resurses.enums.ProjectNames;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    public static final String CONTENT_DESKTOP = "#content-desktop";
    public static final String MAIN_APP = ".main-app";

    public static void verifyLoaderIsNotVisible() {
        logger.info("Verifying that the loader is not visible");
        $(By.id("loader")).shouldNotBe(visible);
        logger.info("Loader is not visible");
    }

    public static void verifyPageIsLoaded(String parentElementID, String pageName) {
        logger.info("Verifying that page '{}' is loaded", pageName);
        $(parentElementID)
                .find("h2")
                .shouldHave(text(pageName));
        logger.info("Page '{}' is loaded", pageName);
    }

    public static void verifyPageIsLoaded(String parentElementID, PageTitles pageTitle) {
        verifyPageIsLoaded(parentElementID, pageTitle.getTitle());
    }

    public static void verifyPageIsLoaded(String parentElementID, ProjectNames projectName) {
        verifyPageIsLoaded(parentElementID, projectName.getName());
    }

    public static void verifyMessage(SelenideElement element, String expectedMessage) {
        logger.info("Verifying the message is present: '{}'", expectedMessage);
        element.shouldHave(text(expectedMessage));
        logger.info("Message '{}' is present", expectedMessage);
    }
}