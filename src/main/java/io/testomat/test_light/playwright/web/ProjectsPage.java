package io.testomat.test_light.playwright.web;

import com.microsoft.playwright.Page;

public class ProjectsPage extends BasePage {


    public ProjectsPage(Page page) {
        super(page);
    }

    public ProjectsPage isLoaded() {
        super.isLoaded();
        return this;
    }

    public ProjectsPage verifySigInSuccessMessage() {
        page.locator(".common-flash-success").isVisible();
        return this;
    }

    public ProjectsPage searchProject(String projectName) {
        page.locator(".common-page-header-right #search").fill(projectName);
        return this;
    }

    public void selectProject(String projectName) {
        page.locator("a[title='" + projectName + "']").click();
    }

}
