package com.example.designPattern.chain;

/**
 * 《责任链模式》
 *      将请求的发送和接收解耦，让多个接收对象都有机会处理这个请求。将这些接收对象串成一条链，并沿着这条链传递这个请求，
 *   直到链上的某个接收对象能够处理它为止。
 *
 *  角色介绍：
 *      1、客户端（Client）：实例化一个处理器的链，在第一个链对象中调用handleRequest方法。
 *      2、处理器（Handler）：抽象类，提供给实际处理器继承然后实现handleRequst方法，处理请求
 *      3、具体处理器（ConcreteHandler）：继承了handler的类，同时实现handleRequst方法，负责处理业务逻辑类，不同业务模块有不同的ConcreteHandler。
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class ChainTest {

    public static void main(String[] args) {
        LeaveClient leaveClient = new LeaveClient();
        leaveClient.apply(1);
        leaveClient.apply(2);
        leaveClient.apply(3);
        leaveClient.apply(4);
    }
}
