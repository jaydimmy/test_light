package io.testomat.test_light.web.selenium.common;

import org.openqa.selenium.By;

public class Elements {

    public static ElementsActions find(By locator) {
        return new ElementsActions(locator);
    }

    public static ElementsActions find(String locator) {
        By targetLocator = locator.startsWith("/") ? By.xpath(locator) : By.cssSelector(locator);
        return new ElementsActions(targetLocator);
    }

    public static ElementsActions findByText(String text) {
        return new ElementsActions(By.xpath("//*[(text()='" + text + "']"));
    }

}
