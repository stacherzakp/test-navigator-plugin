package com.staszkox.test.navigator.configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TestAnnotations
{
    JUNIT4("org.junit.Test"),
    JUNIT5("org.junit.jupiter.api.Test");

    private final String fullTestAnnotationClassName;

    TestAnnotations(String fullTestAnnotationClassName)
    {
        this.fullTestAnnotationClassName = fullTestAnnotationClassName;
    }

    public static List<String> getAllAnnotationNames()
    {
        return Arrays.stream(TestAnnotations.values())
                .map(testAnnotation -> testAnnotation.fullTestAnnotationClassName)
                .collect(Collectors.toList());
    }
}
