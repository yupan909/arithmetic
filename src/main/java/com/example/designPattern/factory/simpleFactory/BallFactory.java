package com.example.designPattern.factory.simpleFactory;

import com.example.designPattern.factory.Ball;
import com.example.designPattern.factory.BasketBall;
import com.example.designPattern.factory.FootBall;

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
