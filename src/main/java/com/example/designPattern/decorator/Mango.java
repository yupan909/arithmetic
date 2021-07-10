package com.example.designPattern.decorator;

/**
 * 芒果
 *
 * @author yupan
 * @date 7/10/21 2:33 PM
 */
public class Mango extends Condiment {

    public Mango(Beverage beverage) {
        super(beverage);
    }

    /**
     * 描述
     */
    @Override
    public String desc() {
        return super.desc() + " + 芒果（3元）";
    }

    /**
     * 价格
     */
    @Override
    public Integer cost() {
        return super.cost() + 3;
    }

}
