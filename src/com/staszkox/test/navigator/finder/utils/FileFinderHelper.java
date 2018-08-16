package com.staszkox.test.navigator.finder.utils;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.FileIndexFacade;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiClass;

public class FileFinderHelper
{
    public static Module getClassModule(PsiClass clazz)
    {
        Project project = clazz.getProject();
        VirtualFile clazzVirtualFile = getVirtualFile(clazz);

        return FileIndexFacade.getInstance(project).getModuleForFile(clazzVirtualFile);
    }

    private static VirtualFile getVirtualFile(PsiClass clazz)
    {
        return clazz.getContainingFile().getVirtualFile();
    }
}
