package io.testomat.test_light.web.pages.enums;

public enum ProjectNames {
    MANUFACTURE_LIGHT("Manufacture Light"),
    MANUFACTURE_TESTOMATIO("Manufacture Testomatio");

    public final String name;

    ProjectNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
