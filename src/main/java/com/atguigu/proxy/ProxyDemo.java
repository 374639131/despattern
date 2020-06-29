package com.atguigu.proxy;

import com.atguigu.builder.ComputerConcreteBuilder;

import java.util.function.Predicate;

/**
 * @program: DesignPattern
 * @description: 代理模式
 * @author: Li huachang
 * @create: 2020-06-19 09:17
 */

interface Company{
    void findWokers();
}

class  HR implements Company{

    @Override
    public void findWokers() {
        System.out.println("HR 找员工");
    }
}

class Proxy implements Company{

    private HR hr;

    @Override
    public void findWokers() {
        System.out.println("代理模式下的HR");
        hr=new HR();
        hr.findWokers();

    }
}


public class ProxyDemo {
    public static void main(String[] args) {
        Proxy proxy =new Proxy();
        proxy.findWokers();
    }
}