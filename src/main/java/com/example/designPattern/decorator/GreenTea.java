package com.example.designPattern.decorator;

/**
 * 绿茶
 *
 * @author yupan
 * @date 7/10/21 2:29 PM
 */
public class GreenTea implements Beverage{

    @Override
    public String desc() {
        return "绿茶（" + cost() + "元）";
    }

    @Override
    public Integer cost() {
        return 12;
    }

}
