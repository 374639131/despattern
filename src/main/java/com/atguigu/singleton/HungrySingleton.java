package com.atguigu.singleton;

/**
 * @program: DesignPattern
 * @description: 饿汉模式(线程安全)
 * @author: Li huachang
 * @create: 2020-06-07 21:14
 */
public class HungrySingleton {
    private static   HungrySingleton hungrySingleton =new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}