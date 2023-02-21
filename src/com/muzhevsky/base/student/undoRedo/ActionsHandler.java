package com.muzhesky.student.undoRedo;

import com.muzhesky.structures.Stack;

public abstract class ActionsHandler {
    protected Stack<Action> actions = new Stack<>();
    public void addAction(Action action){
        actions.push(action);
    }
}
