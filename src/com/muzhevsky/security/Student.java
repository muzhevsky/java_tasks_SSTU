package com.muzhevsky.security;

public class Student extends Human{
    @Override
    public void tryToPassSecurity(Security security){
        security.check(this);
    }
}
