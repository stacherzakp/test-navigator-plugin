package com.staszkox.test.navigator.files.checkers;

import com.intellij.codeInsight.AnnotationUtil;
import com.intellij.psi.PsiClass;
import org.jetbrains.plugins.groovy.lang.psi.impl.statements.typedef.GrClassDefinitionImpl;
import org.jetbrains.plugins.groovy.lang.psi.impl.statements.typedef.members.GrMethodImpl;

import java.util.Arrays;
import java.util.List;

import static com.intellij.codeInsight.AnnotationUtil.CHECK_TYPE;

public class ClassContentChecker {

    private static final List<String> testAnnotationNames = TestMethodAnnotation.getAllAnnotationNames();

    public static boolean hasTestCases(PsiClass clazz) {

        if (clazz instanceof GrClassDefinitionImpl) {
            return Arrays.stream(clazz.getAllMethods()).anyMatch(method -> method instanceof GrMethodImpl);
        }

        return Arrays.stream(clazz.getAllMethods()).anyMatch(method -> AnnotationUtil.isAnnotated(method, testAnnotationNames, CHECK_TYPE));
    }
}
