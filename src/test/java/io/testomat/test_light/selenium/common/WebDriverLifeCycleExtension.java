package io.testomat.test_light.selenium.common;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.test_light.selenium.web.common.WebDriverProvider.driver;

public class WebDriverLifeCycleExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        driver();
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        driver().quit();
    }
}

