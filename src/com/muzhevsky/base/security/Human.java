package com.muzhesky.security;

public class Human {
    public void tryToPassSecurity(Security security) {
        security.check(this);
    }
}
