package io.testomat.test_light.playwright.web;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public abstract class BasePage {
    protected final Page page;
    private final Locator loader;
    private final Locator pageHeader;

    protected BasePage(Page page) {
        this.page = page;
        this.loader = page.locator("#loader");
        this.pageHeader = page.locator("#content-desktop h2");
    }


    public void loaderIsHidden() {
        assertThat(loader).isHidden();
    }

    public BasePage isLoaded() {
        loaderIsHidden();
        assertThat(pageHeader).isVisible();
        return this;
    }

    public void open(String url) {
        page.navigate(url);
    }
}