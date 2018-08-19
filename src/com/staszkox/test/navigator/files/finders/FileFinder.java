package com.staszkox.test.navigator.files.finders;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.search.GlobalSearchScope;
import com.staszkox.test.navigator.files.finders.utils.FileFinderHelper;

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
        Module module = FileFinderHelper.getClassModule(clazz);
        String fileToFind = getFileNameForSearch();

        JavaPsiFacade javaPsiFacade = JavaPsiFacade.getInstance(project);
        PsiClass matchedTestFile = javaPsiFacade.findClass(fileToFind, GlobalSearchScope.moduleScope(module));

        return Optional.ofNullable(matchedTestFile);
    }

    protected abstract String getFileNameForSearch();

    PsiClass getBaseClass()
    {
        return clazz;
    }
}
