package com.example.designPattern.factory.abstractFactory;

import com.example.designPattern.factory.Ball;

/**
 * 体育用品工厂类
 *
 * @author yupan
 * @date 7/4/21 2:33 PM
 */
public interface SportFactory {

    /**
     * 获取球类
     * @return
     */
    Ball createBall();

    /**
     * 获取球衣
     * @return
     */
    Shirt createShirt();

}
