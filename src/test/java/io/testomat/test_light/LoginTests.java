package io.testomat.test_light;

import io.testomat.test_light.web.pages.ProjectsPage;
import io.testomat.test_light.web.pages.SignInPage;
import org.junit.jupiter.api.Test;

import static io.testomat.test_light.web.pages.BasePage.verifyLoaderIsNotVisible;

public class LoginTests extends BaseTest {
    public static final ProjectsPage projectsPage = new ProjectsPage();
    public static final SignInPage signInPage = new SignInPage();

    @Test
    public void testSuccessfulLogin() {
        verifyLoaderIsNotVisible();
        projectsPage.isLoaded();
        projectsPage.verifySigInSuccessMessage();
    }

    @Test
    public void testUnsuccessfulLogin() {
        testSignOut();
        signInPage.login("invalid@example.com", "wrongpassword");
        signInPage.verifyInvalidEmailOrPasswordMessage();
    }

    @Test
    public void testSignOut() {
        verifyLoaderIsNotVisible();
        projectsPage.isLoaded();
        projectsPage.verifySigInSuccessMessage();
        projectsPage.performSignOut();
        verifyLoaderIsNotVisible();
        signInPage.isLoaded();
        signInPage.verifyYouMustBeLoggedMessage();
    }
}
