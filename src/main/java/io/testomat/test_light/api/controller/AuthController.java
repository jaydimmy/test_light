package io.testomat.test_light.api.controller;

public class AuthController extends BaseController {

    public String loginUser(String validEmail, String validPassword) {
        return testomatApi()
                .formParam("email", validEmail)
                .formParam("password", validPassword)
                .post("/login")
                .jsonPath().getString("jwt");
    }
}
