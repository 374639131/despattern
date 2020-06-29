package com.atguigu;

import com.atguigu.singleton.LazySingleton;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        App app =new App();
        app.add();
    }



    public  static  void  add(){
        Map<Integer,Integer>map=new HashMap<>();
        map.put(null,null);
        map.put(1,1);
        Integer integer = map.get(2);
        System.out.println(99);
    }

    protected int print(){


        return 0;
    }

}

interface  Inte{
    int kk = 0;

     static int  getkk(){
        return kk;
    }
}
