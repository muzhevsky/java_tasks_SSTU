package com.muzhesky.main;

import com.muzhesky.connection.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;

        for(int i = 0; i < Connection.maxConnectionAmount; i++){
            connection = Connection.getNewConnection();
            System.out.println(connection.getValue());
        }

        connection.close();
        System.out.println(connection.getValue());
    }
}