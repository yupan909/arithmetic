package com.example.designPattern.decorator;

/**
 * 红茶
 *
 * @author yupan
 * @date 7/10/21 2:29 PM
 */
public class RedTea implements Beverage{

    @Override
    public String desc() {
        return "红茶（" + cost() + "元）";
    }

    @Override
    public Integer cost() {
        return 10;
    }

}
