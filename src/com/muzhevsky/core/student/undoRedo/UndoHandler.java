package com.muzhevsky.core.student.undoRedo;

public class UndoHandler extends ActionsHandler {
    private static UndoHandler instance;

    public static UndoHandler getInstance() {
        if (instance == null)
            instance = new UndoHandler();

        return instance;
    }

    private UndoHandler() {

    }

    public void Undo() {
        Action action = actions.pop();
        action.Undo();
        RedoHandler.getInstance().addAction(action);
    }
}
