package com.atguigu.template;

/**
 * @program: DesignPattern
 * @description:模板模式：在从设计模式中定义了一个算法框架，并通过继承的方式将
 * 算法的实现延迟到字类中去，使字类可以不改变算法的框架及其流程的前提下重新定义
 * 该算法在某些特定的环节，是一种类型为模式
 * @author: Li huachang
 * @create: 2020-06-30 09:09
 */

abstract class AbstractTemplate{

    //摸板方法
    public void templateMethod(){
        checkNumber();
        queueUp();
        handleBusiness();
        serviceEvaluation();
    }

    //抽号
    public void checkNumber(){
        System.out.println("抽号");
    }

    //排队
    public void queueUp(){
        System.out.println("排队");
    }

    //办理业务
    public abstract void handleBusiness();

    //服务评价
    public void serviceEvaluation(){
        System.out.println("服务评价");
    }
}

class SaveMoney extends AbstractTemplate{

    @Override
    public void handleBusiness() {
        System.out.println("存钱");
    }
}

class TakeMoney extends AbstractTemplate{

    @Override
    public void handleBusiness() {
        System.out.println("取钱");
    }
}



public class TemplateDemo {
    public static void main(String[] args) {
        AbstractTemplate template=new SaveMoney();
        template.templateMethod();
    }
}