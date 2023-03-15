package com.muzhevsky.core.student.undoRedo;

import com.muzhevsky.core.structures.Stack;

public abstract class ActionsHandler {
    protected Stack<Action> actions = new Stack<>();

    public void addAction(Action action) {
        actions.push(action);
    }
}
