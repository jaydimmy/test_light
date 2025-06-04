package io.testomat.test_light;

import io.testomat.test_light.web.pages.ProjectsPage;
import io.testomat.test_light.web.pages.SignInPage;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        new ProjectsPage().isLoaded()
                .verifySigInSuccessMessage();
    }

    @Test
    public void testSignOut() {
        new ProjectsPage().isLoaded()
                .verifySigInSuccessMessage()
                .signOut();
        new SignInPage().isLoaded()
                .verifyYouMustBeLoggedMessage();
    }
}
