package com.atguigu.singleton;

/**
 * @program: DesignPattern
 * @description:静态内部类安全
 * @author: Li huachang
 * @create: 2020-06-07 21:17
 */
public class SingletonHolder {

    private SingletonHolder(){

    }

    private static class  Singleton{
        private static final SingletonHolder instance=new SingletonHolder();
    }

    public static SingletonHolder getInstance(){
        return Singleton.instance;
    }

}