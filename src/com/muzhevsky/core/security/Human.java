package com.muzhevsky.core.security;

import com.muzhevsky.spring.utils.toString.ToString;
import com.muzhevsky.spring.utils.toString.ToStringParameter;

public class Human {
    public void tryToPassSecurity(Security security) {
        security.check(this);
    }
}
