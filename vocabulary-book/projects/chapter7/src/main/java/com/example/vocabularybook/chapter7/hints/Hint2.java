package com.example.vocabularybook.chapter7.hints;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class Hint2 implements MethodBeforeAdvice, AfterReturningAdvice {
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

