package com.atguigu.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DesignPattern
 * @description:迭代器模式提供了顺序访问集合中的对象中的各个元素，而不暴露对象内部结构的方法
 * @author: Li huachang
 * @create: 2020-07-03 21:31
 */


interface  CustomizeIterator{
    //指针前移
    Object previous();
    //指针后移
    Object next();
    boolean hasNext();
}

class  ConcreteIterator implements CustomizeIterator{

    CustomizeCollection collection = null;
    int pos=-1;

    public ConcreteIterator(CustomizeCollection collection) {
        this.collection = collection;
    }

    @Override
    public Object previous() {
        if (pos>0)
            pos--;
        return collection.get(pos);
    }

    @Override
    public Object next() {

        if (pos<collection.size()-1)
            pos++;
        return collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        if (pos<collection.size()-1)
            return true;
        return false;
    }
}


interface CustomizeCollection{

    CustomizeIterator iterator();

     Object get(int i);
     void add(Object o);
     int size();
}

class  ListCollection implements CustomizeCollection{

    List list=new ArrayList();

    @Override
    public CustomizeIterator iterator() {
        return new ConcreteIterator(this);
    }

    @Override
    public Object get(int i) {
        return list.get(i);
    }

    @Override
    public void add(Object o) {
        list.add(o);
    }

    @Override
    public int size() {
        return list.size();
    }
}





public class IteratorDemo {

    public static void main(String[] args) {
        CustomizeCollection collection=new ListCollection();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);

        CustomizeIterator iterator = collection.iterator();

        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

    }


}