package com.staszkox.test.navigator.files.checkers;

import com.intellij.psi.PsiClass;
import com.staszkox.test.navigator.configuration.TestNavigatorConfig;

public class ClassTypeChecker
{
    private static final TestNavigatorConfig config = TestNavigatorConfig.getInstance();

    private final PsiClass psiClass;

    public static ClassTypeChecker of(PsiClass psiClass)
    {
        return new ClassTypeChecker(psiClass);
    }

    private ClassTypeChecker(PsiClass psiClass)
    {
        this.psiClass = psiClass;
    }

    public boolean isTestClass()
    {
        return psiClass != null && nameEndsWithTestSuffix();
    }

    public boolean isSourceClass()
    {
        return psiClass != null && !nameEndsWithTestSuffix();
    }

    private boolean nameEndsWithTestSuffix()
    {
        return psiClass.getQualifiedName() != null && config.getTestClassSuffixes().stream()
                .anyMatch(suffix -> psiClass.getQualifiedName().endsWith(suffix));
    }
}
