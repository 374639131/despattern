package com.atguigu.singleton;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: DesignPattern
 * @description: 双重校验 安全
 * @author: Li huachang
 * @create: 2020-06-07 21:26
 */
public class LockSingleton {

    private volatile  static LockSingleton instance=null;
    private LockSingleton(){}

    public static LockSingleton getInstance (){
        if (instance==null)
        {
            /**
             * 其中有两次判断是否为空的语句，第一次是为了提高效率，避免每次都要执行同步代码块，第二次判空，是为了避免多线程带来的不安全，
             * 当两个线程同时对第一个判断为空时，均会先后进入同步代码块，此时，若没有第二个判空条件，则会引来创建多个实例。
             uniqueInstance采用volatile关键字修饰很有必要
             * */
            synchronized (LockSingleton.class){
                if (instance==null)
                {
                    instance =new LockSingleton();
                }
            }
        }
        return instance;
    }
}