package com.staszkox.test.navigator.files.finders;

import com.intellij.psi.PsiClass;
import com.staszkox.test.navigator.configuration.TestNavigatorConfig;

import java.util.List;
import java.util.stream.Collectors;

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
    protected List<String> getFileNamesForSearch()
    {
        List<String> testClassSuffixes = TestNavigatorConfig.getInstance().getTestClassSuffixes();

        return testClassSuffixes.stream()
                .map(suffix -> getBaseClass().getQualifiedName().replace(suffix, ""))
                .filter(fileForSearch -> !getBaseClass().getQualifiedName().equals(fileForSearch))
                .collect(Collectors.toList());
    }
}
