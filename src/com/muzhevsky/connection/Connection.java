package com.muzhevsky.connection;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    public static final int maxConnectionAmount = 3;
    private static List<Connection> connections = new ArrayList<Connection>();
    private State state;

    private enum State {
        OPENED,
        CLOSED
    }

    static {
        for (int i = 0; i < maxConnectionAmount; i++) {
            Connection newConnection = new Connection();
            connections.add(newConnection);
        }
    }

    private Connection() {
        this.state = State.CLOSED;
    }

    public static Connection getNewConnection() {
        for (Connection item : connections) {
            if (item.getState() == State.CLOSED) {
                item.state = State.OPENED;
                return item;
            }
        }

        System.out.println("there are no available connections at the moment");
        return null;
    }

    public void close() {
        this.state = State.CLOSED;
        connections.set(connections.indexOf(this), new Connection());
    }

    public static void closeAllConnections() {
        for (Connection item : connections)
            item.close();
    }

    public State getState() {
        return this.state;
    }

    public String getValue(){
        if(this.state == State.OPENED)
            return "test string";

        throw new ConnectionClosedException("Connection is closed");
    }
}
class ConnectionClosedException extends RuntimeException{
    public ConnectionClosedException(String str){
        super(str);
    }
}