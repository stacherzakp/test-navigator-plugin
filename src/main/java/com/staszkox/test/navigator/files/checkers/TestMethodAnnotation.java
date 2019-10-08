package com.staszkox.test.navigator.files.checkers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TestMethodAnnotation {
    JUNIT4("org.junit.Test"),
    JUNIT5("org.junit.jupiter.api.Test"),
    JUNIT5_REPEATED_TEST("org.junit.jupiter.api.RepeatedTest"),
    JUNIT5_PARAMETRIZED_TEST("org.junit.jupiter.params.ParameterizedTest");

    private final String fullTestAnnotationClassName;

    TestMethodAnnotation(String fullTestAnnotationClassName) {
        this.fullTestAnnotationClassName = fullTestAnnotationClassName;
    }

    public static List<String> getAllAnnotationNames() {
        return Arrays.stream(TestMethodAnnotation.values())
                .map(testAnnotation -> testAnnotation.fullTestAnnotationClassName)
                .collect(Collectors.toList());
    }
}
