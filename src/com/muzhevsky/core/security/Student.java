package com.muzhevsky.core.security;

public class Student extends Human {
    @Override
    public void tryToPassSecurity(Security security) {
        security.check(this);
    }
}
