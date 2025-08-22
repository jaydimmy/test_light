package io.testomat.test_light.selenide;

import io.testomat.test_light.helpers.EnvHelper;
import io.testomat.test_light.selenide.web.pages.ProjectsPage;
import io.testomat.test_light.selenide.web.pages.SignInPage;
import org.junit.jupiter.api.Test;

import static io.testomat.test_light.selenide.BaseTest.validEmail;
import static io.testomat.test_light.selenide.BaseTest.validPassword;

public class LoginTests {


    static {
        EnvHelper.configure();
    }

    private static final String invalidEmail = "invalid@email.com";
    private static final String invalidPassword = "invalidPassword";

    @Test
    public void testSuccessfulLogin() {
        new SignInPage().login(validEmail, validPassword);
        new ProjectsPage().isLoaded()
                .verifySigInSuccessMessage();
    }

    @Test
    public void testUnsuccessfulLogin() {
        new SignInPage().open()
                .isLoaded()
                .enterUserEmail(invalidEmail)
                .enterUserPassword(invalidPassword)
                .checkRememberMe()
                .clickSignInButton()
                .verifyInvalidEmailOrPasswordMessage();
    }

    @Test
    public void testSignOut() {
        new SignInPage().login(validEmail, validPassword);
        new ProjectsPage().isLoaded()
                .verifySigInSuccessMessage()
                .signOut();
        new SignInPage().isLoaded()
                .verifyYouMustBeLoggedMessage();
    }
}
