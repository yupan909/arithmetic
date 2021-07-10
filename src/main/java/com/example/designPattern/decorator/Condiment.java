package com.example.designPattern.decorator;

/**
 * 调料抽象类
 *
 * @author yupan
 * @date 7/10/21 2:31 PM
 */
public abstract class Condiment implements Beverage {

    private Beverage beverage;

    public Condiment(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * 描述
     */
    @Override
    public String desc() {
        return this.beverage.desc();
    }

    /**
     * 价格
     */
    @Override
    public Integer cost() {
        return this.beverage.cost();
    }
}
