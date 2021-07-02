package com.example.designPattern.factoryMethod;

/**
 * 《工厂方法模式》
 *     定义了一个创建对象的抽象方法，由子类决定要实例化的类。工厂方法模式将对象的实例化推迟到子类。
 *
 * @author yupan
 * @date 7/2/21 11:16 AM
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        // 足球工厂
        FootBallFactory footBallFactory = new FootBallFactory();
        // 大号足球
        Ball largeFootBall = footBallFactory.createBall("l");
        largeFootBall.play();
        // 小号足球
        Ball smallFootBall = footBallFactory.createBall("s");
        smallFootBall.play();

        // 篮球工厂
        BasketBallFactory basketBallFactory = new BasketBallFactory();
        // 大号篮球
        Ball largeBasketBall = basketBallFactory.createBall("l");
        largeBasketBall.play();
        // 小号篮球
        Ball smallBasketBall = basketBallFactory.createBall("s");
        smallBasketBall.play();
    }
}
