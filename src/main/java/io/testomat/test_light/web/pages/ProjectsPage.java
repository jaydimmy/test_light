package io.testomat.test_light.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.testomat.test_light.web.pages.BasePage.CONTENT_DESKTOP;
import static io.testomat.test_light.web.pages.BasePage.verifyLoaderIsNotVisible;
import static io.testomat.test_light.web.pages.BasePage.verifyPageIsLoaded;

public class ProjectsPage {
    private static final Logger logger = LoggerFactory.getLogger(ProjectsPage.class);
    private final ElementsCollection companyOptions = $$("#company_id option");
    private final SelenideElement searchInput = $(".common-page-header-right #search");
    private final SelenideElement userMenuButton = $("button#user-menu-button");
    private final SelenideElement profileMenu = $("#profile-menu");
    private final SelenideElement signOutButton = profileMenu.find("button[type='submit']");
    private final SelenideElement successMessage = $(".common-flash-success");
    public static final String MANUFACTURE_LIGHT = "Manufacture light";
    public static final String QA_CLUB_LVIV = "QA Club Lviv";
    public static final String MANUFACTURE_TESTOMATIO = "Manufacture Testomatio";

    public ProjectsPage isLoaded() {
        verifyLoaderIsNotVisible();
        verifyPageIsLoaded(CONTENT_DESKTOP, "Projects");
        return this;
    }

    public ProjectsPage verifySelectedCompany(String companyName) {
        logger.info("Verifying selected company: {}", companyName);
        companyOptions
                .findBy(text(companyName))
                .shouldBe(visible, selected);
        logger.info("Company '{}' is selected", companyName);
        return this;
    }

    public ProjectsPage searchProject(String sectionName) {
        logger.info("Searching for project section: {}", sectionName);
        searchInput.setValue(sectionName);
        searchInput.shouldHave(value(sectionName));
        logger.info("Project section '{}' entered in search", sectionName);
        return this;
    }

    public ProjectsPage selectProject(String sectionName) {
        logger.info("Selecting project section: {}", sectionName);
        $("a[title='" + sectionName + "']")
                .click();
        logger.info("Project section '{}' selected", sectionName);
        return this;
    }

    public ProjectsPage verifySigInSuccessMessage() {
        logger.info("Verifying sign in success message");
        successMessage.shouldHave(text("Signed in successfully"));
        logger.info("Sign in success message is present");
        return this;
    }

    public ProjectsPage openUserCornerMenu() {
        logger.info("Opening user corner menu");
        userMenuButton.click();
        profileMenu.shouldBe(visible);
        logger.info("User corner menu opened");
        return this;
    }

    public ProjectsPage signOut() {
        logger.info("Performing sign out");
        openUserCornerMenu();
        signOutButton.shouldHave(text("Sign Out")).click();
        logger.info("Sign out completed");
        return this;
    }
}





