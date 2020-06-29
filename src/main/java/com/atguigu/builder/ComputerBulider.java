package com.atguigu.builder;

/**
 * @program: DesignPattern
 * @description:用来描述产品构造和装配过程
 * @author: Li huachang
 * @create: 2020-06-14 09:27
 */
public interface ComputerBulider {
    void buildCPU();
    void buildMemory();
    Computer buildComputer();
}