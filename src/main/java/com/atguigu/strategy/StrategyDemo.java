package com.atguigu.strategy;

/**
 * @program: DesignPattern
 * @description:策略模式：为同一个行为定义不同的策略，每个策略都是实现不同的方法
 * 改模式的优点避免掉很多if else
 * @author: Li huachang
 * @create: 2020-06-29 08:59
 */


interface TravelStrategy{
    void travelMode();
}

class TravelStrategyByAir implements TravelStrategy{

    @Override
    public void travelMode() {
        System.out.println("乘飞机去");
    }
}

class TravelStrategyByCar implements TravelStrategy{

    @Override
    public void travelMode() {
        System.out.println("乘汽车去");
    }
}

class ContextStrategy{
    private TravelStrategy travelStrategy;

    public TravelStrategy getTravelStrategy() {
        return travelStrategy;
    }

    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void selectMode(){
        travelStrategy.travelMode();
    }

}



public class StrategyDemo {

    public static void main(String[] args) {
        TravelStrategy car=new TravelStrategyByCar();
        TravelStrategy air=new TravelStrategyByAir();
        ContextStrategy contextStrategy=new ContextStrategy();
        contextStrategy.setTravelStrategy(air);
        contextStrategy.selectMode();
    }
}