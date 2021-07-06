package com.example.designPattern.bridge;

/**
 * 手机
 *
 * @author yupan
 * @date 7/6/21 6:39 PM
 */
public abstract class Phone {

    /**
     * 手机品牌
     */
    protected Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    abstract void call();
}
