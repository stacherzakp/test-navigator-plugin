package com.staszkox.test.navigator.files.utils;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.FileIndexFacade;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiClass;

import java.util.Objects;
import java.util.Optional;

public class PsiClassHelper {
    private static final String JAVA_EXT = "java";
    private static final String GROOVY_EXT = "groovy";

    public static Optional<Module> getClassModule(PsiClass clazz) {

        Project project = clazz.getProject();
        VirtualFile clazzVirtualFile = getVirtualFile(clazz);

        if (clazzVirtualFile != null) {
            Module classModule = FileIndexFacade.getInstance(project).getModuleForFile(clazzVirtualFile);
            return Optional.ofNullable(classModule);
        } else {
            return Optional.empty();
        }
    }

    public static boolean isSupportedClassType(PsiClass psiClass) {
        VirtualFile virtualFile = getVirtualFile(psiClass);
        return virtualFile != null && isSupportedExtension(virtualFile);
    }

    private static boolean isSupportedExtension(VirtualFile virtualFile) {
        return Objects.equals(virtualFile.getExtension(), JAVA_EXT) || Objects.equals(virtualFile.getExtension(), GROOVY_EXT);
    }

    private static VirtualFile getVirtualFile(PsiClass clazz) {

        if (clazz == null || clazz.getContainingFile() == null) {
            return null;
        }

        return clazz.getContainingFile().getVirtualFile();
    }
}
