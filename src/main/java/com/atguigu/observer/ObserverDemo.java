package com.atguigu.observer;

import org.omg.CORBA.Object;
import sun.awt.SubRegionShowable;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DesignPattern
 * @description:观察者模式，
 * @author: Li huachang
 * @create: 2020-07-01 10:30
 */

interface Observer{
    void receive(String message);
}


class ConcreteObserver1 implements Observer{

    @Override
    public void receive(String message) {
        System.out.println("ConcreteObserver1收到："+message+"的消息");
    }
}

class ConcreteObserver2 implements Observer{

    @Override
    public void receive(String message) {
        System.out.println("ConcreteObserver2收到："+message+"的消息");
    }
}




abstract  class  Subject{
    List<Observer> observerList=new ArrayList<>();

   public void addObserver(Observer observer){
       observerList.add(observer);
   }

   public void removeObserver(Observer observer){
       observerList.remove(observer);
   }

   public abstract void notifyObservers(String msg);

}

class ConcreteSubject extends Subject{

    @Override
    public void notifyObservers(String msg) {
        for (Observer observer : observerList) {
            observer.receive(msg);
        }
    }
}



public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject =new ConcreteSubject();
        Observer observer1=new ConcreteObserver1();
        Observer observer2=new ConcreteObserver2();
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.notifyObservers("观察者变化了");
    }
}