package com.staszkox.test.navigator.configuration;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TestAnnotations
{
    JUNIT(Test.class);

    private final Class annotationClass;

    TestAnnotations(Class annotationClass)
    {
        this.annotationClass = annotationClass;
    }

    public static List<String> getAllAnnotationNames()
    {
        return Arrays.stream(TestAnnotations.values())
                .map(testAnnotation -> testAnnotation.annotationClass.getCanonicalName())
                .collect(Collectors.toList());
    }
}
