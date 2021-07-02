package com.example.designPattern.factoryMethod.simpleFactory;

/**
 * 《简单工厂模式》
 *      简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例
 *
 *      简单工厂是属于创建型模式，但不属于23种设计模式之一。
 *  主要是因为其不符合6大设计原则中的总原则—开闭原则：就是说对扩展开放，对修改关闭。
 *
 *  优点：比较好理解，简单易操作。
 *  缺点：违反了设计模式的开闭原则，即对扩展开放，对修改关闭。当我们需要增加一个类型时，都需要修改工厂类。
 *
 * @author yupan
 * @date 7/2/21 11:16 AM
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        Ball footBall = BallFactory.createBall("football");
        footBall.play();

        Ball basketball = BallFactory.createBall("basketball");
        basketball.play();
    }
}
