package com.example.designPattern.bridge;

/**
 * 滑盖手机
 *
 * @author yupan
 * @date 7/6/21 6:41 PM
 */
public class SlidePhone extends Phone {

    public SlidePhone(Brand brand) {
        super(brand);
    }

    @Override
    public void call() {
        System.out.println(brand.explain() + "滑盖手机打电话");
    }
}
