package com.muzhevsky.core.utils;

import com.muzhevsky.core.utils.annotations.Cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CacheHandler implements InvocationHandler {

    private Map<MethodInvocationData, Object> _cachedData = new HashMap<>();


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) return method.invoke(proxy, args);

        for (var item : _cachedData.keySet()){
            if (item.method == method && Arrays.equals(item.args, args))
                return _cachedData.get(item);
        }

        var result = method.invoke(proxy, args);
        _cachedData.put(new MethodInvocationData(method, args), result);
        return result;
    }


    class MethodInvocationData{
        private Method method;
        private Object[] args;

        MethodInvocationData(Method method, Object[] args) {
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
}
