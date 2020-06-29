package com.atguigu.builder;

/**
 * @program: DesignPattern
 * @description:构建者模式中的Product
 * @author: Li huachang
 * @create: 2020-06-14 09:24
 */
public class Computer {

    private String cpu;
    private String memory;
    private String disk;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                '}';
    }
}