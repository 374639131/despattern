package com.atguigu.prototype;

/**
 * @program: DesignPattern
 * @description: 深复制和浅复制
 * @author: Li huachang
 * @create: 2020-06-15 08:10
 */
public class CopyDemo {
}



/**
 * 浅复制
 * */
class Computer implements Cloneable{

    public String cpu;
    public String memory;
    public String disk;

    public Computer(String cpu, String memory, String disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    @Override
    protected Computer clone() throws CloneNotSupportedException {
        return (Computer)super.clone();
    }
}

class ComputerDetail implements Cloneable{
    public String cpu;
    public String memory;
    public Disk disk;

    public ComputerDetail(String cpu, String memory, Disk disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    @Override
    protected ComputerDetail clone() throws CloneNotSupportedException {

        ComputerDetail computerDetail = (ComputerDetail) super.clone();
        Disk cloneDisk = this.disk.clone();
        computerDetail.disk=cloneDisk;
        return computerDetail;
    }
}


class Disk implements Cloneable{
    public String ssd;
    public String hhd;

    public Disk(String ssd, String hhd) {
        this.ssd = ssd;
        this.hhd = hhd;
    }

    @Override
    protected Disk clone() throws CloneNotSupportedException {
        return (Disk)super.clone();
    }
}