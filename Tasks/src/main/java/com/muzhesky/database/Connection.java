package com.muzhesky.database;

public class Connection {
    public static final int maxConnectionAmount = 3;
    private static int actualConnectionAmount;
    private static Connection[] connectionList = new Connection[maxConnectionAmount];

    private Connection(){

    }

    public static Connection getNewConnection(){
        if(actualConnectionAmount < maxConnectionAmount){
            Connection newConnection = new Connection();
            connectionList[actualConnectionAmount++] = new Connection();
            return newConnection;
        }

        System.out.println("cant create more than " + maxConnectionAmount +" connections");
        return null;
    }
}
