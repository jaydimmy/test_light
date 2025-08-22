package io.testomat.test_light.web.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import io.testomat.test_light.web.playwright.common.Options;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.testomat.test_light.resurses.enums.ProjectNames.MANUFACTURE_LIGHT;
import static io.testomat.test_light.resurses.helpers.EnvHelper.getEnvValue;

@UsePlaywright(Options.class)
public class ProjectsTests {

    protected static final String validEmail = getEnvValue("USER_EMAIL");
    protected static final String validPassword = getEnvValue("USER_PASSWORD");
    protected static final String projectName = MANUFACTURE_LIGHT.getName();

    @Test
    @DisplayName("Find project and open test")
    void findProjectAndOpenTest(Page page) {
        new SignInPage(page).open()
                .isLoaded()
                .login(validEmail, validPassword);
        new ProjectsPage(page).isLoaded()
                .verifySigInSuccessMessage()
                .searchProject(projectName)
                .selectProject(projectName);
        new ProjectPage(page)
                .isLoaded()
                .verifyProjectName(projectName);
    }
}
