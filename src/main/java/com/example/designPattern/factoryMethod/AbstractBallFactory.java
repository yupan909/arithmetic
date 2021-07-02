package com.example.designPattern.factoryMethod;

/**
 * 抽象球类工厂类
 *
 * @author yupan
 * @date 7/2/21 7:01 PM
 */
public abstract class AbstractBallFactory {

    public abstract Ball createBall(String type);
}
