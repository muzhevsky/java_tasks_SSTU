package com.muzhesky.security;

public class Teacher extends Human {
    @Override
    public void tryToPassSecurity(Security security){  // Двойная диспетчеризация
        security.check(this);
    }
}