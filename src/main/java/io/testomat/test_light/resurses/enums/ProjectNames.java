package io.testomat.test_light.resurses.enums;

public enum ProjectNames {
    MANUFACTURE_LIGHT("manufacture light"),
    MANUFACTURE_TESTOMATIO("Manufacture Testomatio");

    public final String name;

    ProjectNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
