package com.staszkox.test.navigator.files.finders;

import com.intellij.psi.PsiClass;
import com.staszkox.test.navigator.configuration.TestNavigatorConfig;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestFileFinder extends FileFinder {

    public static TestFileFinder forClass(PsiClass sourceClass) {
        return new TestFileFinder(sourceClass);
    }

    private TestFileFinder(PsiClass sourceClass) {
        super(sourceClass);
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
                    .map(suffix -> qualifiedClassName + suffix)
                    .filter(fileForSearch -> !qualifiedClassName.equals(fileForSearch))
                    .collect(Collectors.toList());
        }

        return fileNamesForSearch;
    }
}
