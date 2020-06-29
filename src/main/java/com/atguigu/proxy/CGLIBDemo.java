package com.atguigu.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: DesignPattern
 * @description: 基于字类的动态代理
 * @author: Li huachang
 * @create: 2020-06-23 18:08
 */


class HelloService{
    public void hello(){
        System.out.println("HelloService构造");
    }
}


class MyMethodInterceptor implements MethodInterceptor{


    /**
     * sub：cglib生成的代理对象
     * method：被代理对象方法
     * objects：方法入参
     * methodProxy: 代理方法
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("前置通知");
        Object invoke = methodProxy.invokeSuper(sub, objects);
        System.out.println("后置通知");
        return invoke;
    }
}


public class CGLIBDemo {

    public static void main(String[] args) {

        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(HelloService.class);
        enhancer.setCallback(new MyMethodInterceptor());
        HelloService proxy = (HelloService)enhancer.create();
        proxy.hello();
    }
}