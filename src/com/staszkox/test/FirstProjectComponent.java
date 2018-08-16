package com.staszkox.test;

import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.util.messages.MessageBusConnection;

public class FirstProjectComponent extends AbstractProjectComponent
{
    protected FirstProjectComponent(Project project)
    {
        super(project);
    }

    @Override
    public void projectOpened()
    {
        MessageBusConnection busConnection = myProject.getMessageBus().connect(myProject);
        busConnection.subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new FileListenerr());
    }
}
