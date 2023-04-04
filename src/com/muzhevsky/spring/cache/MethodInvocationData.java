package com.muzhevsky.spring.cache;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public     class MethodInvocationData{
    private Method method;
    private Object[] args;
    private Object owner;

    public Object getOwner(){
        return owner;
    }

    public Method getMethod(){
        return method;
    }
    public Object[] getArgs(){
        return Arrays.copyOf(args, args.length);
    }

    public MethodInvocationData(Object owner, Method method, Object[] args) {
        this.owner = owner;
        this.method = method;
        this.args = args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodInvocationData that = (MethodInvocationData) o;
        return Objects.equals(method, that.method);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(method);
        return result;
    }
}