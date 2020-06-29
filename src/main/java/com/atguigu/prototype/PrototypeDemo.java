package com.atguigu.prototype;

/**
 * @program: DesignPattern
 * @description: 原型态模式，主要利用复制。
 * @author: Li huachang
 * @create: 2020-06-15 08:17
 */
public class PrototypeDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        //浅复制
        Computer computer=new Computer("i7","8G","ssd");
        Computer computerClone = computer.clone();
        computer.cpu="amd 12";

        //深复制
        ComputerDetail detail =new ComputerDetail("i7","8G",new Disk("ssd","hhd"));

        ComputerDetail computerDetailClone = detail.clone();
        detail.memory="三习惯";
        int i=0;
    }

}