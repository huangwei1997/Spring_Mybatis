package com.xjtu.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        if(o!=null){
            System.out.println(o.toString()+"登录成功");
        }else{
            System.out.println(objects[0]+"登录失败，该用户不存在");
        }


    }
}
