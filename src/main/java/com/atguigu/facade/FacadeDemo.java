package com.atguigu.facade;

/**
 * @program: DesignPattern
 * @description: 外观模式
 * @author: Li huachang
 * @create: 2020-06-20 13:57
 */

class Dashboard{
    public void start(){
        System.out.println("仪表盘启动");
    }

    public void shutdown(){
        System.out.println("仪表盘关闭");
    }
}

class Engine{
    public void start(){
        System.out.println("发动机启动");
    }

    public void shutdown(){
        System.out.println("发动机关闭");
    }
}


class Facade{
    private Engine engine;
    private Dashboard dashboard;

    public Facade(Engine engine, Dashboard dashboard) {
        this.engine = engine;
        this.dashboard = dashboard;
    }

    public void start(){
        dashboard.start();
        engine.start();
    }

    public void shutdown(){
        dashboard.shutdown();
        engine.shutdown();
    }
}


public class FacadeDemo {

    public static void main(String[] args) {
        Facade facade=new Facade(new Engine(),new Dashboard());
        facade.start();
        facade.shutdown();
    }


}