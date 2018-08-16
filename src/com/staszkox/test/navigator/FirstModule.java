package com.staszkox.test.navigator;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleComponent;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.ProjectManager;

public class FirstModule implements ModuleComponent
{
    @Override
    public void moduleAdded()
    {
        ProjectManager projectManager = ProjectManager.getInstance();
        ModuleManager moduleManager = ModuleManager.getInstance(projectManager.getOpenProjects()[0]);

        Module module = moduleManager.getModules()[0];
        System.out.println("Added " + module.getName());
    }
}
