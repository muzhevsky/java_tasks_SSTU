package com.notSmartCoder.student;

public abstract class UndoRedoHandler {
    private static RedoHandler redoHandler = new RedoHandler();
    private static UndoHandler undoHandler = new UndoHandler();

    public static void addUndoAction(Action action){
        undoHandler.addAction(action);
        redoHandler.clear();
    }

    public static void addRedoAction(Action action){
        redoHandler.addAction(action);
    }

    public static void Undo(){
        redoHandler.addAction(undoHandler.Undo());
    }
    public static void Redo(){
        undoHandler.addAction(redoHandler.Redo());
    }
}
