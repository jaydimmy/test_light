package io.testomat.test_light.web.pages;

import com.codeborne.selenide.Selectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static io.testomat.test_light.web.pages.BasePage.MAIN_APP;
import static io.testomat.test_light.web.pages.BasePage.verifyLoaderIsNotVisible;
import static io.testomat.test_light.web.pages.BasePage.verifyPageIsLoaded;

public class ProjectPage {
    private static final Logger logger = LoggerFactory.getLogger(ProjectPage.class);

    public ProjectPage isLoaded(String targetProjectName) {
        logger.info("Verifying Project page is loaded for project: {}", targetProjectName);
        verifyLoaderIsNotVisible();
        verifyPageIsLoaded(MAIN_APP, targetProjectName);
        logger.info("Project page loaded for project: {}", targetProjectName);
        return this;
    }

    public ProjectPage openReadme() {
        logger.info("Opening Readme tab");
        $(Selectors.byLinkText("Readme")).click();
        logger.info("Readme tab opened");
        return this;
    }

    public ProjectPage clickOnEditButton() {
        logger.info("Clicking on 'Edit' button");
        $(Selectors.byText("Edit")).click();
        logger.info("'Edit' button clicked");
        return this;
    }
}