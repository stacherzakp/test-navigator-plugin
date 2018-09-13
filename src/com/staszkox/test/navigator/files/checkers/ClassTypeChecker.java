package com.staszkox.test.navigator.files.checkers;

import com.intellij.psi.PsiClass;
import com.staszkox.test.navigator.configuration.TestFileSuffix;

public class ClassTypeChecker
{
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
        return psiClass.getQualifiedName() != null && psiClass.getQualifiedName().endsWith(TestFileSuffix.TEST_SUFFIX);
    }
}
