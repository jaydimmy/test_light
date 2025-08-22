package io.testomat.test_light.api.controller;

import static io.restassured.http.ContentType.JSON;

public class ProjectsController extends BaseController {

    public String getProjectIdByName(String jwtToken, String targetProjectName) {
        return testomatApi()
                .header("Authorization", jwtToken)
                .contentType(JSON)
                .get("/projects")
                .jsonPath().getString("data.find { it.attributes.title == '" + targetProjectName + "' }.id");
    }
}
