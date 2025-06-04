package io.testomat.test_light.web.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.testomat.test_light.web.pages.BasePage.MAIN_APP;
import static io.testomat.test_light.web.pages.BasePage.verifyLoaderIsNotVisible;
import static io.testomat.test_light.web.pages.BasePage.verifyPageIsLoaded;
import static org.openqa.selenium.Keys.END;

public class ReadmePage {
    private static final Logger logger = LoggerFactory.getLogger(ReadmePage.class);

    private final SelenideElement textarea = $("textarea");
    private final SelenideElement firstEditLine = $(".view-lines div");

    public ReadmePage isLoaded() {
        logger.info("Verifying Readme page is loaded");
        verifyLoaderIsNotVisible();
        verifyPageIsLoaded(MAIN_APP, "Readme");
        logger.info("Readme page loaded");
        return this;
    }

    public ReadmePage clickOnEditReadmeButton() {
        logger.info("Clicking on 'Edit Readme' button");
        $(Selectors.byText("Edit Readme")).click();
        logger.info("'Edit Readme' button clicked");
        return this;
    }

    public ReadmePage switchToIframe() {
        logger.info("Switching to Readme iframe");
        switchTo().frame($("#modal-overlays iframe[src='/ember-monaco/frame.html']"));
        logger.info("Switched to Readme iframe");
        return this;
    }

    public ReadmePage editReadmeFirstLine(String targetText) {
        logger.info("Editing first line in Readme with text: {}", targetText);
        firstEditLine.click();
        actions().sendKeys(END).perform();
        textarea.sendKeys(targetText);
        firstEditLine.shouldHave(text(targetText));
        logger.info("First line edited in Readme");
        return this;
    }

    public ReadmePage switchToDefaultContent() {
        logger.info("Switching to default content from iframe");
        switchTo().defaultContent();
        logger.info("Switched to default content");
        return this;
    }

    public ReadmePage clickOnUpdateButton() {
        logger.info("Clicking on 'Update' button");
        $(Selectors.byText("Update")).click();
        logger.info("'Update' button clicked");
        return this;
    }

    public ReadmePage clickOnCancelButton() {
        logger.info("Clicking on 'Cancel' button");
        $(Selectors.byText("Cancel")).click();
        logger.info("'Cancel' button clicked");
        return this;
    }
}