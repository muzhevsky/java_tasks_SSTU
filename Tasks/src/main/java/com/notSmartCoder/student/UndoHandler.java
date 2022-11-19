package com.notSmartCoder.student;

public class UndoHandler extends ActionsHandler {
    public Action Undo(){
        Action action = actions.pop();
        action.Undo();
        return action;
    }
    public void addAction(Action action){
        actions.push(action);
    }
}
