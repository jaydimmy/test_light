package io.testomat.test_light.web.selenium.common;

import org.openqa.selenium.By;

import static io.testomat.test_light.web.selenium.common.WebDriverProvider.driver;

public class ElementsActions {
    private final By selector;

    public ElementsActions(By selector) {
        this.selector = selector;
    }

    public void click() {
        waitFor().visibility();
        driver().findElement(selector).click();
    }

    public void sendKeys(String text) {
        waitFor().visibility();
        driver().findElement(selector).sendKeys(text);
    }

    public Waits waitFor() {
        return new Waits(this.selector);
    }
}
