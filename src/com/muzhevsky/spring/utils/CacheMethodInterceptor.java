package com.muzhevsky.spring.utils;

import com.muzhevsky.spring.utils.annotations.Cache;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CacheMethodInterceptor implements MethodInterceptor {
    Map<MethodInvocationData, Object> _cachedData = new HashMap<>();

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) return method.invoke(proxy, args);

        for (var item : _cachedData.keySet()){
            if (item.getMethod() == method && Arrays.equals(item.getArgs(), args) && obj == item.getOwner())
                return _cachedData.get(item);
        }

        var result = proxy.invokeSuper(obj, args);
        _cachedData.put(new MethodInvocationData(obj, method, args), result);
        return result;
    }
}
