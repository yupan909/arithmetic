package com.example.designPattern.factory.abstractFactory;

/**
 * 长袖球衣
 *
 * @author yupan
 * @date 7/4/21 2:15 PM
 */
public class LongShirt implements Shirt {

    @Override
    public void show() {
        System.out.println("穿着长袖球衣");
    }
}
