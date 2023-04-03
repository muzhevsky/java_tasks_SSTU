package com.muzhevsky.spring.utils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public     class MethodInvocationData{
    private Method method;
    private Object[] args;

    public Method getMethod(){
        return method;
    }
    public Object[] getArgs(){
        return Arrays.copyOf(args, args.length);
    }

    public MethodInvocationData(Method method, Object[] args) {
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