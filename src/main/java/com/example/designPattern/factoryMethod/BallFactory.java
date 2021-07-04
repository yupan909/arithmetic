package com.example.designPattern.factoryMethod;

/**
 * 球类工厂类
 *
 * @author yupan
 * @date 7/2/21 7:01 PM
 */
public interface BallFactory {

    Ball createBall(String type);
}
