package com.atguigu.adapter;

/**
 * @program: DesignPattern
 * @description:对象适配
 * @author: Li huachang
 * @create: 2020-06-17 09:52
 */

class ObjectSource{
    public void editTextFile(){
        System.out.println("原类修改文件");
    }
}
interface ObjectTargetable{
    /**待适配的方法*/
    void editTextFile();
    void editWordFile();
}

class ObjectAda implements ObjectTargetable{
    private ObjectSource objectSource;

    public ObjectAda(ObjectSource objectSource) {
        this.objectSource = objectSource;
    }

    @Override
    public void editTextFile() {
        this.objectSource.editTextFile();
    }

    @Override
    public void editWordFile() {
        System.out.println("修改word文件");
    }
}

public class ObjectAdapter {

    public static void main(String[] args) {
        ObjectAda objectAda =new ObjectAda(new ObjectSource());
        objectAda.editTextFile();
        objectAda.editWordFile();
    }
}