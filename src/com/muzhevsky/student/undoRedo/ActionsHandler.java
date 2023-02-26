package com.muzhevsky.student.undoRedo;

import com.muzhevsky.structures.Stack;

public abstract class ActionsHandler {
    protected Stack<Action> actions = new Stack<>();
    public void addAction(Action action){
        actions.push(action);
    }
}
