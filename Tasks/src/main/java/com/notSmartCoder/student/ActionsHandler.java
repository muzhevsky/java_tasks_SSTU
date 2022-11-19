package com.notSmartCoder.student;

import com.notSmartCoder.structures.Stack;

public abstract class ActionsHandler {
    protected Stack<Action> actions = new Stack<>();
    public void clear(){
        actions.clear();
    }
}
