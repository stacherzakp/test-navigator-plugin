package com.staszkox.test.finder;

import com.intellij.psi.PsiClass;
import com.staszkox.test.configuration.TestFileSuffix;

public class SourceFileFinder extends FileFinder
{
    private SourceFileFinder(PsiClass testClass)
    {
        super(testClass);
    }

    public static SourceFileFinder forClass(PsiClass testClass)
    {
        return new SourceFileFinder(testClass);
    }

    @Override
    protected String getFileNameForSearch()
    {
        return getBaseClass().getQualifiedName().replace(TestFileSuffix.TEST_SUFFIX, "");
    }
}
