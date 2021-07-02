package com.example.designPattern.factoryMethod;

/**
 * 足球工厂类
 *
 * @author yupan
 * @date 7/2/21 7:07 PM
 */
public class FootBallFactory extends AbstractBallFactory{

    @Override
    public Ball createBall(String type) {
        if ("l".equals(type)) {
            return new FootLargeBall();
        } else if ("s".equals(type)) {
            return new FootSmallBall();
        }
        return null;
    }
}
