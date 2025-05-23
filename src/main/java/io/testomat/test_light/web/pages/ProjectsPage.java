package io.testomat.test_light.web.pages;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.testomat.test_light.web.pages.BasePage.verifyPageIsLoaded;

public class ProjectsPage {
    private static final Logger logger = LoggerFactory.getLogger(ProjectsPage.class);

    public void isLoaded() {
        verifyPageIsLoaded("#content-desktop", "Projects");
    }

    public void verifySelectedCompany(String companyName) {
        logger.info("Verifying selected company: {}", companyName);
        $$("#company_id option")
                .findBy(text(companyName))
                .shouldBe(visible, selected);
        logger.info("Company '{}' is selected", companyName);
    }

    public void findProject(String sectionName) {
        logger.info("Searching for project section: {}", sectionName);
        SelenideElement searchInput = getSearchInput();
        searchInput.setValue(sectionName);
        searchInput.shouldHave(value(sectionName));
        logger.info("Project section '{}' entered in search", sectionName);
    }

    public static SelenideElement getSearchInput() {
        logger.info("Getting search input element");
        SelenideElement input = $(".common-page-header-right #search")
                .shouldBe(visible);
        logger.info("Search input element is visible");
        return input;
    }

    public void selectProject(String sectionName) {
        logger.info("Selecting project section: {}", sectionName);
        $("a[title='" + sectionName + "']")
                .click();
        logger.info("Project section '{}' selected", sectionName);
    }

    public void verifySigInSuccessMessage() {
        logger.info("Verifying sign in success message");
        $(".common-flash-success")
                .shouldHave(text("Signed in successfully"));
        logger.info("Sign in success message is present");
    }

    public void openUserCornerMenu() {
        logger.info("Opening user corner menu");
        $("button#user-menu-button").click();
        $("#profile-menu").shouldBe(visible);
        logger.info("User corner menu opened");
    }

    public void performSignOut() {
        logger.info("Performing sign out");
        openUserCornerMenu();
        $("#profile-menu button[type='submit']")
                .shouldHave(text("Sign Out"))
                .click();
        logger.info("Sign out button clicked");
    }
}





