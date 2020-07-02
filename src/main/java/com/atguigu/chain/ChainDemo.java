package com.atguigu.chain;

/**
 * @program: DesignPattern
 * @description:责任链模式，用于避免请求发送者与多个请求者耦合在一起
 * @author: Li huachang
 * @create: 2020-07-02 19:48
 */

interface Handler{
    void operate();
}


abstract class AbstractHandler{
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}


class AuthHandler extends AbstractHandler implements Handler{

    @Override
    public void operate() {
        System.out.println("授权处理：");
        Handler handler= getHandler();
        if (handler!=null){
            handler.operate();
        }
    }
}


class BusinessHandler extends AbstractHandler implements Handler{

    @Override
    public void operate() {
        System.out.println("处理业务处理器");
        Handler handler= getHandler();
        if (handler!=null){
            handler.operate();
        }
    }
}


class ResponseHandler extends AbstractHandler implements Handler{

    @Override
    public void operate() {
        System.out.println("反应处理器");
        Handler handler= getHandler();
        if (handler!=null){
            handler.operate();
        }
    }
}



public class ChainDemo {

    public static void main(String[] args) {
        AuthHandler authHandler=new AuthHandler();
        BusinessHandler businessHandler=new BusinessHandler();
        ResponseHandler responseHandler =new ResponseHandler();
        authHandler.setHandler(businessHandler);
        businessHandler.setHandler(responseHandler);
        authHandler.operate();
    }
}