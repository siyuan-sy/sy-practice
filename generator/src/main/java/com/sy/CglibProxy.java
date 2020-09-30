package com.sy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    // 初始化Enhancer对象
    private Enhancer enhancer = new Enhancer();
    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz); // 指定生成的代理类的父类
        enhancer.setCallback(this); // 设置Callback对象
        return enhancer.create(); // 通过ASM字节码技术动态创建子类实例
    }

    // 实现MethodInterceptor接口的intercept()方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("前置处理");
        Object result = proxy.invokeSuper(obj, args); // 调用父类中的方法
        System.out.println("后置处理");
        return result;
    }
}
