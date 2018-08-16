package com.staszkox.test;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class FileLoaded extends AnAction
{
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent)
    {
//        VirtualFile file = anActionEvent.getDataContext().getData(CommonDataKeys.VIRTUAL_FILE);
//        System.out.println("File opened! " + file);
//
//        VirtualFile data = anActionEvent.getData(PlatformDataKeys.VIRTUAL_FILE);
//        System.out.println("File opened! " + data);

//        final Editor editor = anActionEvent.getRequiredData(CommonDataKeys.EDITOR);
//
//        EditorActionHandler actionHandler = new EditorActionHandler()
//        {
//            @Override
//            protected void doExecute(Editor editor, @Nullable Caret caret, DataContext dataContext)
//            {
//                System.out.println("AAAA");
//                super.doExecute(editor, caret, dataContext);
//            }
//        };
//
//        actionHandler.execute(editor, editor.getCaretModel().getCurrentCaret(), anActionEvent.getDataContext());
//        System.out.println("XXXX");
    }

    @Override
    public void update(AnActionEvent e)
    {
        System.out.println("XXX");
        e.getPresentation().setEnabled(true);
        e.getPresentation().setEnabledAndVisible(true);
    }
}
