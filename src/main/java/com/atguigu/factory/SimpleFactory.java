package com.atguigu.factory;

/**
 * @program: DesignPattern
 * @description: 简单工厂模式
 * @author: Li huachang
 * @create: 2020-06-10 21:19
 */

interface  Iphone{
    String bands();
}

class HuaWei implements Iphone{

    @Override
    public String bands() {
        return "这是华为";
    }
}

class Apple implements Iphone{

    @Override
    public String bands() {
        return "这是苹果";
    }
}

public class SimpleFactory {

    public Iphone creatPhone(String name){
        if (name.equals("华为"))
        {
            return new HuaWei();
        }
        else if (name.equals("苹果")){
            return new Apple();
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        SimpleFactory factory=new SimpleFactory();
       Iphone huawei= factory.creatPhone("华为");
       Iphone apple= factory.creatPhone("苹果");
        System.out.println(huawei.bands());
        System.out.println(apple.bands());
    }

}