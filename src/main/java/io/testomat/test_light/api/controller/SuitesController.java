package io.testomat.test_light.api.controller;

import io.restassured.response.Response;
import io.testomat.test_light.api.dto.CreateSuiteRequest;

import static io.restassured.http.ContentType.JSON;

public class SuitesController extends BaseController {

    public Response getSuitesForProject(String jwtToken, String projectId) {
        return testomatApi()
                .header("Authorization", jwtToken)
                .get("/" + projectId + "/suites");
    }

    public Response createNewSuite(String jwtToken, CreateSuiteRequest data, String projectId) {
        return testomatApi()
                .header("Authorization", jwtToken)
                .contentType(JSON)
                .body(data)
                .post("/" + projectId + "/suites");
    }
}
