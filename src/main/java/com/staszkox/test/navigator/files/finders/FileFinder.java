package com.staszkox.test.navigator.files.finders;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.search.GlobalSearchScope;
import com.staszkox.test.navigator.files.utils.PsiClassHelper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

abstract class FileFinder
{
    private final PsiClass clazz;

    FileFinder(PsiClass clazz)
    {
        this.clazz = clazz;
    }

    public final Optional<PsiClass> findFile()
    {
        Project project = clazz.getProject();
        Module module = PsiClassHelper.getClassModule(clazz);
        List<String> filesToFind = getFileNamesForSearch();

        JavaPsiFacade javaPsiFacade = JavaPsiFacade.getInstance(project);

        return filesToFind.stream()
                .map(fileToFind -> javaPsiFacade.findClass(fileToFind, GlobalSearchScope.moduleScope(module)))
                .filter(Objects::nonNull)
                .findFirst();
    }

    protected abstract List<String> getFileNamesForSearch();

    PsiClass getBaseClass()
    {
        return clazz;
    }
}
