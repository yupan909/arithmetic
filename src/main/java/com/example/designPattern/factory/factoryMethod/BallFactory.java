package com.example.designPattern.factory.factoryMethod;

import com.example.designPattern.factory.Ball;

/**
 * 生产球类的工厂接口
 *
 * @author yupan
 * @date 7/2/21 7:01 PM
 */
public interface BallFactory {

    Ball createBall();
}
