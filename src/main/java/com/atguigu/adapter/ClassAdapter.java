package com.atguigu.adapter;

import com.sun.corba.se.impl.protocol.giopmsgheaders.TargetAddress;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @program: DesignPattern
 * @description: 适配器模式---类适配
 * @author: Li huachang
 * @create: 2020-06-17 09:46
 */
class  Source{
    public void editTextFile(){
        System.out.println("原类修改文件");
    }
}

interface Targetable{
    /**待适配的方法*/
   void editTextFile();
   void editWordFile();
}


class Adapter extends Source implements Targetable{
    @Override
    public void editWordFile() {
        System.out.println("修改word文档");
 }

}


public class ClassAdapter {
    public static void main(String[] args) {
        Targetable targetable =new Adapter();
        targetable.editTextFile();
        targetable.editWordFile();
    }
}