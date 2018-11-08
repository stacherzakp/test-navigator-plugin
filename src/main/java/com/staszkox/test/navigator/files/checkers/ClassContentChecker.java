package com.staszkox.test.navigator.files.checkers;

import com.intellij.codeInsight.AnnotationUtil;
import com.intellij.psi.PsiClass;

import java.util.Arrays;
import java.util.List;

public class ClassContentChecker
{
    private static final List<String> testAnnotationNames = TestAnnotations.getAllAnnotationNames();

    public static boolean hasTestCases(PsiClass clazz)
    {
        return Arrays.stream(clazz.getAllMethods()).anyMatch(method -> AnnotationUtil.isAnnotated(method, testAnnotationNames));
    }
}
