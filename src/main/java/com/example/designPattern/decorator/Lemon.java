package com.example.designPattern.decorator;

/**
 * 柠檬
 *
 * @author yupan
 * @date 7/10/21 2:33 PM
 */
public class Lemon extends Condiment {

    public Lemon(Beverage beverage) {
        super(beverage);
    }

    /**
     * 描述
     */
    @Override
    public String desc() {
        return super.desc() + " + 柠檬（2元）";
    }

    /**
     * 价格
     */
    @Override
    public Integer cost() {
        return super.cost() + 2;
    }

}
