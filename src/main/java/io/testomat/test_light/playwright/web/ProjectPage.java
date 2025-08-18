package io.testomat.test_light.playwright.web;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProjectPage extends BasePage {
    private final Locator pageHeader = page.locator(".sticky-header h2");

    public ProjectPage(Page page) {
        super(page);
    }

    @Override
    public ProjectPage isLoaded() {
        super.loaderIsHidden();
        assertThat(pageHeader).isVisible();
        return this;
    }

    public void verifyProjectName(String projectName) {
        assertThat(pageHeader).hasText(projectName);
    }
}