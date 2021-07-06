package com.example.designPattern.bridge;

/**
 * 折叠手机
 *
 * @author yupan
 * @date 7/6/21 6:40 PM
 */
public class FoldPhone extends Phone {

    public FoldPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void call() {
        System.out.println(brand.explain() + "折叠手机打电话");
    }
}
