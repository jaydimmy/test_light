package io.testomat.test_light.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data(staticConstructor = "of")
@Accessors(chain = true)
public class CreateSuiteRequest {

    private SuiteData data;

    @Data(staticConstructor = "of")
    @Accessors(chain = true)
    public static class SuiteData {
        private String type;
        private SuiteAttributes attributes;
    }

    @Data(staticConstructor = "of")
    @Accessors(chain = true)
    public static class SuiteAttributes {
        private String title;
        private String description;
    }
}