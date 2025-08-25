package io.testomat.test_light.api.controller;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.testomat.test_light.resurses.helpers.EnvHelper.getEnvValue;

public class BaseController {
    protected static final String baseUrl = getEnvValue("BASE_URL");


    protected RequestSpecification testomatApi() {
        return RestAssured.given()
                .baseUri(baseUrl)
                .basePath("/api")
                .accept(ContentType.JSON);
    }
}
