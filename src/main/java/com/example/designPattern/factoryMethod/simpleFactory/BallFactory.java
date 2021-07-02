package com.example.designPattern.factoryMethod.simpleFactory;

/**
 * 球类工厂类
 *
 * @author yupan
 * @date 7/2/21 4:57 PM
 */
public class BallFactory {

    public static Ball createBall(String type) {
         if ("football".equals(type)) {
             return new FootBall();
         } else if ("basketball".equals(type)) {
             return new BasketBall();
         } else {
             return null;
         }
    }
}
