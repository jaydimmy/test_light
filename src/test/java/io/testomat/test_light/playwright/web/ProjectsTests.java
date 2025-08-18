package io.testomat.test_light.playwright.web;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import io.testomat.test_light.playwright.web.common.Options;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.testomat.test_light.enums.ProjectNames.MANUFACTURE_LIGHT;
import static io.testomat.test_light.helpers.EnvHelper.getEnvValue;

@UsePlaywright(Options.class)
public class ProjectsTests {

    public static final String validEmail = getEnvValue("USER_EMAIL");
    public static final String validPassword = getEnvValue("USER_PASSWORD");
    public static final String projectName = MANUFACTURE_LIGHT.getName();

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
