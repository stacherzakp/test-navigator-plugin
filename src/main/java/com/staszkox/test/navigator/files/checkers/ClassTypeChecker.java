package com.staszkox.test.navigator.files.checkers;

import com.intellij.psi.PsiClass;
import com.staszkox.test.navigator.configuration.TestNavigatorConfig;

import java.util.Collections;
import java.util.List;

public class ClassTypeChecker {

    public static ClassTypeChecker of(PsiClass psiClass) {
        return new ClassTypeChecker(psiClass);
    }

    private final PsiClass psiClass;

    private ClassTypeChecker(PsiClass psiClass) {
        this.psiClass = psiClass;
    }

    public boolean isTestClass() {
        return psiClass != null && nameEndsWithTestSuffix();
    }

    public boolean isSourceClass() {
        return psiClass != null && !nameEndsWithTestSuffix();
    }

    private boolean nameEndsWithTestSuffix() {

        TestNavigatorConfig config = TestNavigatorConfig.getInstance();
        List<String> testSuffixes = config != null ?
                config.getTestClassSuffixes() : Collections.emptyList();

        return psiClass.getQualifiedName() != null && testSuffixes.stream()
                .anyMatch(suffix -> psiClass.getQualifiedName().endsWith(suffix));
    }
}
