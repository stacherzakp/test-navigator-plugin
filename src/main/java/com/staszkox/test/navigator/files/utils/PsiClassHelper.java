package com.staszkox.test.navigator.files.utils;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.FileIndexFacade;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiClass;

import java.util.Objects;

public class PsiClassHelper
{
    private static final String JAVA_EXT = "java";

    public static Module getClassModule(PsiClass clazz)
    {
        Project project = clazz.getProject();
        VirtualFile clazzVirtualFile = getVirtualFile(clazz);

        return FileIndexFacade.getInstance(project).getModuleForFile(clazzVirtualFile);
    }

    public static boolean isJavaClass(PsiClass psiClass)
    {
        return psiClass.isPhysical() && Objects.equals(getVirtualFile(psiClass).getExtension(), JAVA_EXT);
    }

    private static VirtualFile getVirtualFile(PsiClass clazz)
    {
        return clazz.getContainingFile().getVirtualFile();
    }
}
