package io.testomat.test_light;

import io.testomat.test_light.web.pages.ProjectPage;
import io.testomat.test_light.web.pages.ProjectsPage;
import org.junit.jupiter.api.Test;

import static io.testomat.test_light.web.pages.enums.CompanyNames.QA_CLUB_LVIV;
import static io.testomat.test_light.web.pages.enums.ProjectNames.MANUFACTURE_LIGHT;

public class ProjectsTests extends BaseTest {

    @Test
    public void findProjectAndOpenTest() {
        new ProjectsPage()
                .isLoaded()
                .verifySelectedCompany(QA_CLUB_LVIV)
                .searchProject(MANUFACTURE_LIGHT)
                .selectProject(MANUFACTURE_LIGHT);
        new ProjectPage()
                .isLoaded(MANUFACTURE_LIGHT);
    }

    @Test
    public void projectsBadgesTest() {
        new ProjectsPage()
                .isLoaded()
                .verifySelectedCompany(QA_CLUB_LVIV)
                .verifyProjectBadges("Cypress.io");
    }
}
