package com.muzhevsky.spring.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CacheHandler implements InvocationHandler {

    private Map<MethodInvocationData, Object> _cachedData = new HashMap<>();


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) return method.invoke(proxy, args);

        for (var item : _cachedData.keySet()){
            if (item.getMethod() == method && Arrays.equals(item.getArgs(), args))
                return _cachedData.get(item);
        }

        var result = method.invoke(proxy, args);
        _cachedData.put(new MethodInvocationData(proxy, method, args), result);
        return result;
    }

}
