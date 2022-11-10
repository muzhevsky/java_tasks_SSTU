package com.notSmartCoder.student;

public abstract class UndoHandler extends ActionsHandler {
    public static Action Undo(){
        Action action = actions.pop();
        action.Undo();
        return action;
    }
}
