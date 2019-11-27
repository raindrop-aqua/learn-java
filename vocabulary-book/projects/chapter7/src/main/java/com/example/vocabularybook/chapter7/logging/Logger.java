package com.example.vocabularybook.chapter7.logging;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Logger implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        // 関数が呼ばれる前に実行されます<1>
        System.out.println("After :" + method.getName() + "[" + target + "]");
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        // 関数が呼ばれて実行されたあとに実行されます<2>
        System.out.println("Before:" + method.getName() + "[" + target + "]");
    }
}
