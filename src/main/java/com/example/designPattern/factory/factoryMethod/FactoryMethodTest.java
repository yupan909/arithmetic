package com.example.designPattern.factory.factoryMethod;

import com.example.designPattern.factory.Ball;

/**
 * 《工厂方法模式》
 *     定义了一个创建对象的抽象方法，由子类决定要实例化的类。工厂方法模式将对象的实例化推迟到子类。
 *
 *  优点：
 *      1、降低了代码耦合度，对象的生成交给子类去完成
 *      2、实现了开放封闭原则 - 每次添加子产品 不需要修改原有代码
 *  缺点：
 *      1、增加了代码量，每个具体产品都需要一个具体工厂
 *      2、当增加抽象产品，也就是添加一个其他产品族，需要修改工厂，违背OCP（开闭原则）
 *
 *  @author yupan
 * @date 7/2/21 11:16 AM
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        // 足球工厂
        FootBallFactory footBallFactory = new FootBallFactory();
        Ball footBall = footBallFactory.createBall();
        footBall.play();

        // 篮球工厂
        BasketBallFactory basketBallFactory = new BasketBallFactory();
        Ball basketBall = basketBallFactory.createBall();
        basketBall.play();
    }
}
