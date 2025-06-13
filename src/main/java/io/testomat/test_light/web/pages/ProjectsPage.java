package io.testomat.test_light.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.testomat.test_light.web.pages.enums.CompanyNames;
import io.testomat.test_light.web.pages.enums.ProjectNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.testomat.test_light.web.pages.BasePage.CONTENT_DESKTOP;
import static io.testomat.test_light.web.pages.BasePage.verifyLoaderIsNotVisible;
import static io.testomat.test_light.web.pages.BasePage.verifyPageIsLoaded;
import static io.testomat.test_light.web.pages.enums.PageTitles.PROJECTS;

public class ProjectsPage {
    private static final Logger logger = LoggerFactory.getLogger(ProjectsPage.class);
    private final ElementsCollection companyOptions = $$("#company_id option");
    private final SelenideElement searchInput = $(".common-page-header-right #search");
    private final SelenideElement userMenuButton = $("button#user-menu-button");
    private final SelenideElement profileMenu = $("#profile-menu");
    private final SelenideElement signOutButton = profileMenu.find("button[type='submit']");
    private final SelenideElement successMessage = $(".common-flash-success");

    public ProjectsPage isLoaded() {
        verifyLoaderIsNotVisible();
        verifyPageIsLoaded(CONTENT_DESKTOP, PROJECTS);
        return this;
    }

    public ProjectsPage verifySelectedCompany(CompanyNames company) {
        String companyName = company.getName();
        logger.info("Verifying selected company: {}", companyName);
        companyOptions
                .findBy(text(companyName))
                .shouldBe(visible, selected);
        logger.info("Company '{}' is selected", companyName);
        return this;
    }

    public ProjectsPage searchProject(ProjectNames project) {
        String projectName = project.getName();
        logger.info("Searching for project section: {}", projectName);
        searchInput.setValue(projectName);
        searchInput.shouldHave(value(projectName));
        logger.info("Project section '{}' entered in search", projectName);
        return this;
    }

    public ProjectsPage selectProject(ProjectNames project) {
        String projectName = project.getName();
        logger.info("Selecting project section: {}", projectName);
        $("a[title='" + projectName + "']")
                .click();
        logger.info("Project section '{}' selected", projectName);
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

    public ProjectsPage verifyProjectBadges(String expectedBadgeName) {
        logger.info("Verifying project badges contain text: {}", expectedBadgeName);
        ElementsCollection projectBadges = $$("ul li .common-badge");
        projectBadges.shouldHave(sizeGreaterThan(1));
        projectBadges.filterBy(text(expectedBadgeName))
                .shouldHave(sizeGreaterThan(0));
        logger.info("Project badge with text '{}' found", expectedBadgeName);
        return this;
    }
}





