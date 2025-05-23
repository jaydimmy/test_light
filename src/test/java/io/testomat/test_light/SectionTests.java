package io.testomat.test_light;

import io.testomat.test_light.web.pages.ProjectPage;
import io.testomat.test_light.web.pages.ProjectsPage;
import org.junit.jupiter.api.Test;

import static io.testomat.test_light.web.pages.BasePage.verifyLoaderIsNotVisible;


public class SectionTests extends BaseTest {

    public static final String MANUFACTURE_LIGHT = "Manufacture light";
    public static final String QA_CLUB_LVIV = "QA Club Lviv";
    public static final ProjectsPage projectsPage = new ProjectsPage();
    public static final ProjectPage projectPage = new ProjectPage();

    @Test
    public void findSectionByNameAndOpenTest() {
        verifyLoaderIsNotVisible();
        projectsPage.isLoaded();
        projectsPage.verifySelectedCompany(QA_CLUB_LVIV);
        projectsPage.findProject(MANUFACTURE_LIGHT);
        projectsPage.selectProject(MANUFACTURE_LIGHT);
        verifyLoaderIsNotVisible();
        projectPage.isLoaded(MANUFACTURE_LIGHT);
    }
}
