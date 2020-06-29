package com.atguigu.decor;

import javax.swing.*;

/**
 * @program: DesignPattern
 * @description:装饰着模式:不改变原有的继承关系，增强其内容
 * @author: Li huachang
 * @create: 2020-06-18 16:06
 */

interface Sourceable{
    void craeteComputer();
}

class Source implements Sourceable{

    @Override
    public void craeteComputer() {
        System.out.println("生产电脑");
    }
}

class Decor implements Sourceable{

    private Sourceable sourceable;

    public Decor(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    @Override
    public void craeteComputer() {
        System.out.println("对Source进行增强");
        sourceable.craeteComputer();
    }
}

public class DecorDemo {
    public static void main(String[] args) {
       Decor decor =new Decor(new Source());
       decor.craeteComputer();
    }

}