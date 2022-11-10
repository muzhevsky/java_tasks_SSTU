package com.notSmartCoder.student;

import com.notSmartCoder.structures.Stack;

public class RedoHandler extends ActionsHandler{
    public static Action Redo(){
        Action action = actions.pop();
        action.Redo();
        return action;
    }
}
