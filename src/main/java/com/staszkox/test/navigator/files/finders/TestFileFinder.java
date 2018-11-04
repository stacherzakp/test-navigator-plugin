package com.staszkox.test.navigator.files.finders;

import com.intellij.psi.PsiClass;
import com.staszkox.test.navigator.configuration.TestNavigatorConfig;

import java.util.List;
import java.util.stream.Collectors;

public class TestFileFinder extends FileFinder
{
    private TestFileFinder(PsiClass sourceClass)
    {
        super(sourceClass);
    }

    public static TestFileFinder forClass(PsiClass sourceClass)
    {
        return new TestFileFinder(sourceClass);
    }

    @Override
    protected List<String> getFileNamesForSearch()
    {
        List<String> testClassSuffixes = TestNavigatorConfig.getInstance().getTestClassSuffixes();

        return testClassSuffixes.stream()
                .map(suffix -> getBaseClass().getQualifiedName() + suffix)
                .filter(fileForSearch -> !getBaseClass().getQualifiedName().equals(fileForSearch))
                .collect(Collectors.toList());
    }
}
