package com.atguigu.singleton;

/**
 * @program: DesignPattern
 * @description: 懒汉设计模式（线程不安全）
 * @author: Li huachang
 * @create: 2020-06-07 21:08
 */
public class LazySingleton
{
 private static LazySingleton instance;

    private LazySingleton() {
    }


    public static  LazySingleton getInstance(){
        if (instance==null)
        {
            instance=new LazySingleton();
        }
        return instance;
    }
}