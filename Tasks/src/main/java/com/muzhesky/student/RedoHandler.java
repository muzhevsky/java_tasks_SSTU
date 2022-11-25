package com.muzhesky.student;

public class RedoHandler extends ActionsHandler{
    private static RedoHandler instance;
    public static RedoHandler getInstance(){
        if(instance == null)
            instance = new RedoHandler();

        return instance;
    }

    public RedoHandler(){

    }
    public void Redo(){
        Action action = actions.pop();
        action.Redo();
        UndoHandler.getInstance().addAction(action);
    }

    public void clear(){
        actions.clear();
    }
}
