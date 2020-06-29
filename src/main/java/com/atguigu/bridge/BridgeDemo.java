package com.atguigu.bridge;

import java.nio.file.Paths;

/**
 * @program: DesignPattern
 * @description: 桥接模式：抽象与实现解耦
 * @author: Li huachang
 * @create: 2020-06-23 18:33
 */

//实现类接口
   interface Color
 {
     void bepaint(String penType,String name);
 }

//典型的抽象类代码：
abstract class Pen{
    Color color;

    public Color getImpl() {
        return color;
    }

    public void setImpl( Color color) {
        this.color = color;
    }

    public abstract void draw(String name);

}

//典型的扩充抽象类代码：
class SmallPen  extends Pen{

    @Override
    public void draw(String name) {
       color.bepaint("小号笔绘制",name);
    }
}

//典型的扩充抽象类代码：
class MiddlePen  extends Pen{

    @Override
    public void draw(String name) {
        color.bepaint("中号笔绘制",name);
    }
}

//典型的扩充抽象类代码：
class BigPen  extends Pen{
    @Override
    public void draw(String name) {
        color.bepaint("大号笔绘制",name);
    }
}

//扩充实现类
class Red implements Color{

    @Override
    public void bepaint(String penType, String name) {
        System.out.println(penType+"红色的"+name+"。");
    }
}

//扩充实现类
class Blue implements Color{

    @Override
    public void bepaint(String penType, String name) {
        System.out.println(penType+"蓝色的"+name+"。");
    }
}

//扩充实现类
class Green  implements Color{

    @Override
    public void bepaint(String penType, String name) {
        System.out.println(penType+"绿色的"+name+"。");
    }
}



public class BridgeDemo {

    public static void main(String[] args) {

        Color color=new Red();
        Pen pen =new SmallPen();
        pen.setImpl(color);
        pen.draw("鲜花");
    }

}