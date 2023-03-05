package com.staszkox.test.navigator.files.finders;

import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.search.GlobalSearchScope;

import java.util.List;
import java.util.Optional;

abstract class FileFinder {

    private final PsiClass clazz;

    FileFinder(PsiClass clazz) {
        this.clazz = clazz;
    }

    public final Optional<PsiClass> findFile() {

        Project project = clazz.getProject();
        JavaPsiFacade javaPsiFacade = JavaPsiFacade.getInstance(project);

        List<String> filesToFind = getFileNamesForSearch();
        for (String fileToFind : filesToFind) {
            PsiClass psiClass = javaPsiFacade.findClass(fileToFind, GlobalSearchScope.allScope(project));
            if (psiClass != null) {
                return Optional.of(psiClass);
            }
        }

        return Optional.empty();
    }

    protected abstract List<String> getFileNamesForSearch();

    PsiClass getBaseClass() {
        return clazz;
    }
}
