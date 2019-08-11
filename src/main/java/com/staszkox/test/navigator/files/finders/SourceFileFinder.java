package com.staszkox.test.navigator.files.finders;

import com.intellij.psi.PsiClass;
import com.staszkox.test.navigator.configuration.TestNavigatorConfig;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SourceFileFinder extends FileFinder {

    public static SourceFileFinder forClass(PsiClass testClass) {
        return new SourceFileFinder(testClass);
    }

    private SourceFileFinder(PsiClass testClass) {
        super(testClass);
    }

    @Override
    protected List<String> getFileNamesForSearch() {

        TestNavigatorConfig configuration = TestNavigatorConfig.getInstance();
        List<String> testClassSuffixes = configuration != null ?
                configuration.getTestClassSuffixes() : Collections.emptyList();

        String qualifiedClassName = getBaseClass().getQualifiedName();

        List<String> fileNamesForSearch = Collections.emptyList();

        if (qualifiedClassName != null) {

            fileNamesForSearch = testClassSuffixes.stream()
                    .map(suffix -> qualifiedClassName.replace(suffix, ""))
                    .filter(fileForSearch -> !qualifiedClassName.equals(fileForSearch))
                    .collect(Collectors.toList());
        }

        return fileNamesForSearch;
    }
}
