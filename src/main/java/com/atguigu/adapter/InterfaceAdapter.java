package com.atguigu.adapter;

/**
 * @program: DesignPattern
 * @description:接口适配
 * @author: Li huachang
 * @create: 2020-06-17 09:58
 */

interface InterfaceAdap{
    void editTextFile();
    void editWordFile();
}

 abstract class AbstractAdp implements InterfaceAdap{

     @Override
     public void editTextFile() {

     }

     @Override
     public void editWordFile() {

     }
 }


 class  subAbap1 extends AbstractAdp{
     @Override
     public void editTextFile() {
         System.out.println("文件");
     }
 }

 class  subAbap2 extends AbstractAdp{
     @Override
     public void editWordFile() {
         System.out.println("word");
     }
 }

public class InterfaceAdapter {
    public static void main(String[] args) {
        AbstractAdp sub1=new subAbap1();
        AbstractAdp sub2=new subAbap2();
        sub1.editTextFile();
        sub2.editWordFile();
    }
}