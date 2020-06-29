package com.atguigu.builder;

/**
 * @program: DesignPattern
 * @description:构造一个使用builder的对象
 * @author: Li huachang
 * @create: 2020-06-14 09:32
 */


class ComputerDirector{
    public Computer constranctComputer(ComputerBulider bulider){
        bulider.buildCPU();;
        bulider.buildMemory();
        return bulider.buildComputer();
    }
}

public class Test {

    public static void main(String[] args) {
        ComputerDirector computerDirector=new ComputerDirector();
        ComputerConcreteBuilder builder=new ComputerConcreteBuilder();
        Computer computer = computerDirector.constranctComputer(builder);
        System.out.println(computer.toString());
    }
}