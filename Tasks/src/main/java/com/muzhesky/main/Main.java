package com.muzhesky.main;

import com.muzhesky.database.Connection;
import com.muzhesky.security.*;
import com.muzhesky.security.Security;

public class Main {
    public static void main(String[] args) {
        Connection con = null;

        for(int i = 0; i < 5; i++)
            con = Connection.getNewConnection();
    }
}