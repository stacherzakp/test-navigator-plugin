package com.staszkox.test.navigator.files.checkers;

import com.intellij.psi.PsiClass;
import com.staszkox.test.navigator.configuration.TestNavigatorConfig;

import java.util.Arrays;
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
        return psiClass != null && (nameEndsWithTestSuffix() || hasTestSuperclass());
    }

    public boolean isSourceClass() {
        return psiClass != null && !isTestClass();
    }

    private boolean hasTestSuperclass() {

        PsiClass superClass = psiClass.getSuperClass();
        boolean hasSuperclass = superClass != null && superClass.getQualifiedName() != null;

        return hasSuperclass && Arrays.stream(TestFileSuperclass.values())
                .anyMatch(superClassType -> superClassType.getSuperclass().equals(superClass.getQualifiedName()));
    }

    private boolean nameEndsWithTestSuffix() {

        TestNavigatorConfig config = TestNavigatorConfig.getInstance();
        List<String> testSuffixes = config != null ?
                config.getTestClassSuffixes() : Collections.emptyList();

        return psiClass.getQualifiedName() != null && testSuffixes.stream()
                .anyMatch(suffix -> psiClass.getQualifiedName().endsWith(suffix));
    }
}
