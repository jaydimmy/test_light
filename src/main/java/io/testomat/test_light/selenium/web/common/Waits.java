package io.testomat.test_light.selenium.web.common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

import static io.testomat.test_light.selenium.web.common.WebDriverProvider.driver;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textMatches;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Waits {
    private final By selector;
    private final WebDriverWait wait;

    public Waits(By selector) {
        this.selector = selector;
        this.wait = new WebDriverWait(driver(), ofSeconds(10));
        this.wait.pollingEvery(ofMillis(100));
    }

    public void visibility() {
        this.wait.withMessage("Element " + selector + " is not visible")
                .until(visibilityOfElementLocated(selector));
    }

    public void hidden() {
        this.wait.withMessage("Element " + selector + " is still visible")
                .until(invisibilityOfElementLocated(selector));
    }

    public void hasText(String expectedText) {
        this.wait.withMessage("Element " + selector + " does not have expected text: " + expectedText)
                .until(textToBe(selector, expectedText));
    }

    public void containsText(String expectedText) {
        this.wait.withMessage("Element " + selector + " does not contain expected text: " + expectedText)
                .until(textMatches(
                        selector, Pattern.compile(
                                Pattern.quote(expectedText),
                                Pattern.CASE_INSENSITIVE
                        )
                ));
    }
}
