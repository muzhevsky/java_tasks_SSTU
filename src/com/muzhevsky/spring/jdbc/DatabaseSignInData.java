package com.muzhevsky.spring.jdbc;

import lombok.Getter;

public class DatabaseSignInData {

    @Getter private String address;
    @Getter private String login;
    @Getter private String password;

    private DatabaseSignInData(){

    }

    public DatabaseSignInData(String address, String login, String password) {
        this.address = address;
        this.login = login;
        this.password = password;
    }
}
