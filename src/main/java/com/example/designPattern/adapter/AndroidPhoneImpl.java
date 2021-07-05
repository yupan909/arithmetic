package com.example.designPattern.adapter;

/**
 * 安卓手机
 *
 * @author yupan
 * @date 7/5/21 9:44 PM
 */
public class AndroidPhoneImpl implements AndroidPhone{

    @Override
    public void androidHeadset() {
        System.out.println("安卓耳机");
    }

    @Override
    public void androidCharger() {
        System.out.println("安卓充电器");
    }
}
