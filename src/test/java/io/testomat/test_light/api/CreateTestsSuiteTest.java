package io.testomat.test_light.api;

import com.github.javafaker.Faker;
import io.testomat.test_light.api.controller.AuthController;
import io.testomat.test_light.api.controller.ProjectsController;
import io.testomat.test_light.api.controller.SuitesController;
import io.testomat.test_light.api.dto.CreateSuiteRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.testomat.test_light.resurses.enums.ProjectNames.MANUFACTURE_LIGHT;
import static io.testomat.test_light.resurses.helpers.EnvHelper.getEnvValue;

public class CreateTestsSuiteTest {

    protected static final String validEmail = getEnvValue("USER_EMAIL");
    protected static final String validPassword = getEnvValue("USER_PASSWORD");
    protected static final String projectName = MANUFACTURE_LIGHT.getName();
    private Faker faker = new Faker();

    @Test
    @DisplayName("Create a new test suite")
    void createTestSuite() {
        String jwtToken = new AuthController().loginUser(validEmail, validPassword);
        String projectId = new ProjectsController().getProjectIdByName(jwtToken, projectName);

        var targetSuite = getTestSuite();

        SuitesController suitesController = new SuitesController();

        suitesController.createNewSuite(jwtToken, targetSuite, projectId)
                .then().statusCode(200);
        suitesController.getSuitesForProject(jwtToken, projectId)
                .then().statusCode(200);
    }

    private CreateSuiteRequest getTestSuite() {
        return CreateSuiteRequest.of()
                .setData(CreateSuiteRequest.SuiteData.of()
                        .setType("suites")
                        .setAttributes(CreateSuiteRequest.SuiteAttributes.of()
                                .setTitle(faker.name().name())
                                .setDescription(faker.name().fullName())
                        )
                );
    }
}