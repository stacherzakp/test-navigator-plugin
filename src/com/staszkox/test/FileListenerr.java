package com.staszkox.test;

import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class FileListenerr implements FileEditorManagerListener
{
    @Override
    public void fileOpened(@NotNull FileEditorManager source, @NotNull VirtualFile file)
    {
        System.out.println("Opened " + file.getCanonicalPath());
    }

    @Override
    public void fileClosed(@NotNull FileEditorManager source, @NotNull VirtualFile file)
    {
        System.out.println("Closed " + file.getCanonicalPath());
    }
}
