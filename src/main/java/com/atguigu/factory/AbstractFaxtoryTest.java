package com.atguigu.factory;

import java.util.concurrent.CompletableFuture;

/**
 * @program: DesignPattern
 * @description: 抽象工厂
 * @author: Li huachang
 * @create: 2020-06-10 21:26
 */

interface  Iphone2{
 String bands();
}

class HuaWei2 implements Iphone{

 @Override
 public String bands() {
  return "这是华为";
 }
}

class Apple2 implements Iphone{

 @Override
 public String bands() {
  return "这是苹果";
 }
}


interface Computer{
 String internet();
}

class HuWeiCom implements Computer{
 @Override
 public String internet() {
  return "华为电脑";
 }
}

class AppleCom implements Computer{
 @Override
 public String internet() {
  return "苹果电脑";
 }

}

abstract class AbstractFaxtory{
 public  abstract Iphone createPhone2(String name);
 public abstract  Computer createCom2(String name);
}


class PhoneFactory extends AbstractFaxtory{

 @Override
 public Iphone createPhone2(String name) {
  if ("华为".equals(name))
  {
   return new HuaWei2();
  }
  return new Apple2();
 }

 @Override
 public Computer createCom2(String name) {
  return null;
 }
}

class CpmputerFactory extends AbstractFaxtory{

 @Override
 public Iphone createPhone2(String name) {
  return null;
 }

 @Override
 public Computer createCom2(String name) {
  if ("华为".equals(name))
  {
   return new HuWeiCom();
  }
  return new AppleCom();
 }
}



 public   class AbstractFaxtoryTest {
  public static void main(String[] args) {
   AbstractFaxtory phoneFactory=new  PhoneFactory();
   System.out.println(phoneFactory.createPhone2("华为").bands());

   AbstractFaxtory ccomFactory=new  CpmputerFactory();
   System.out.println(ccomFactory.createCom2("华为").internet());

  }

}

