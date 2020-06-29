package com.atguigu.proxy;

/**
 * @program: DesignPattern
 * @description: jdk的动态代理，ProxyDemo是静态代理
 * @author: Li huachang
 * @create: 2020-06-23 10:48
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建Person接口
 * @author Gonjan
 */
 interface PersonS {
    //上交班费
    void giveMoney();
}


 class Student implements PersonS {
    private String name;
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        try {
            //假设数钱花了一秒时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上交班费50元");
    }
}


class StuInvocationHandler<T> implements InvocationHandler{

     T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * proxy:代表动态代理对象
     * method：代表正在执行的方法
     * args：代表调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理");
        Object invoke = method.invoke(target, args);
        return invoke;
    }
}




public class JavaProxyDemo {

    public static void main(String[] args) {
        Student student = new Student("张三");
        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler =new StuInvocationHandler<Student>(student);

        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        PersonS proxyInstance = (PersonS)Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[]{PersonS.class}, stuHandler);
        proxyInstance.giveMoney();
    }

}