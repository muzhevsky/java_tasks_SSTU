package com.notSmartCoder.student;

import com.notSmartCoder.structures.Stack;

public abstract class ActionsHandler {
    protected static Stack<Action> actions = new Stack<>();
    public static void addAction(Action action){
        actions.push(action);
    }
}
