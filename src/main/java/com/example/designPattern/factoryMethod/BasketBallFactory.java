package com.example.designPattern.factoryMethod;

/**
 * 篮球工厂类
 *
 * @author yupan
 * @date 7/2/21 7:07 PM
 */
public class BasketBallFactory extends AbstractBallFactory{

    @Override
    public Ball createBall(String type) {
        if ("l".equals(type)) {
            return new BasketLargeBall();
        } else if ("s".equals(type)) {
            return new BasketSmallBall();
        }
        return null;
    }
}
