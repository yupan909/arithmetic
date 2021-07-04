package com.example.designPattern.factory.abstractFactory;

/**
 * 短袖球衣
 *
 * @author yupan
 * @date 7/4/21 2:15 PM
 */
public class ShortShirt implements Shirt {

    @Override
    public void show() {
        System.out.println("穿着短袖球衣");
    }
}
