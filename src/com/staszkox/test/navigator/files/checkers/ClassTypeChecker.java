package com.staszkox.test.navigator.files.checkers;

import com.intellij.psi.PsiClass;
import com.staszkox.test.navigator.configuration.TestFileSuffix;

public class ClassTypeChecker
{
    public static boolean isTestClass(PsiClass clazz)
    {
        return clazz != null && clazz.getQualifiedName() != null &&
                clazz.getQualifiedName().endsWith(TestFileSuffix.TEST_SUFFIX);
    }

    public static boolean isSourceClass(PsiClass clazz)
    {
        return clazz != null && clazz.getQualifiedName() != null &&
                !clazz.getQualifiedName().endsWith(TestFileSuffix.TEST_SUFFIX);
    }
}
