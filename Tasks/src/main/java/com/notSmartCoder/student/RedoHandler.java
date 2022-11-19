package com.notSmartCoder.student;

public class RedoHandler extends ActionsHandler{
    public Action Redo(){
        Action action = actions.pop();
        action.Redo();
        return action;
    }
    public void addAction(Action action){
        actions.push(action);
    }
}
