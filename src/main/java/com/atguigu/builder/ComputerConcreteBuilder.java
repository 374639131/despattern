package com.atguigu.builder;

/**
 * @program: DesignPattern
 * @description: 实现构造和装配该产品的各个组件
 * @author: Li huachang
 * @create: 2020-06-14 09:29
 */
public class ComputerConcreteBuilder implements ComputerBulider {

    Computer computer;

    public ComputerConcreteBuilder() {
        computer=new Computer();
    }

    @Override
    public void buildCPU() {
        System.out.println("构造CPU");
        computer.setCpu("cpu");
    }

    @Override
    public void buildMemory() {
        System.out.println("构造内存");
        computer.setMemory("内存");
    }

    @Override
    public Computer buildComputer() {
        System.out.println("组装电脑");
        return computer;
    }
}