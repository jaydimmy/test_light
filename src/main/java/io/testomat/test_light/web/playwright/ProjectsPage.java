package io.testomat.test_light.web.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProjectsPage extends BasePage {
    private final Locator successMessage = page.locator(".common-flash-success");
    private final Locator searchField = page.locator(".common-page-header-right #search");

    public ProjectsPage(Page page) {
        super(page);
    }

    @Override
    public ProjectsPage isLoaded() {
        super.isLoaded();
        return this;
    }

    public ProjectsPage verifySigInSuccessMessage() {
        successMessage.isVisible();
        return this;
    }

    public ProjectsPage searchProject(String projectName) {
        searchField.fill(projectName);
        return this;
    }

    public void selectProject(String projectName) {
        page.locator("a[title='" + projectName + "']").click();
    }
}