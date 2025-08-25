package io.testomat.test_light.web.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignInPage extends BasePage {
    private final Locator emailField = page.locator("#content-desktop #user_email");
    private final Locator passwordField = page.locator("#content-desktop #user_password");
    private final Locator rememberMeCheckbox = page.locator("#content-desktop #user_remember_me");
    private final Locator submitButton = page.locator("#content-desktop input[type='submit']");

    public SignInPage(Page page) {
        super(page);
    }

    public SignInPage open() {
        super.open("");
        return this;
    }

    @Override
    public SignInPage isLoaded() {
        super.isLoaded();
        return this;
    }

    public void login(String email, String password) {
        emailField.fill(email);
        passwordField.fill(password);
        rememberMeCheckbox.click();
        submitButton.click();
    }
}