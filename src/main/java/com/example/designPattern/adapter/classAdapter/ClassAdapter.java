package com.example.designPattern.adapter.classAdapter;

import com.example.designPattern.adapter.AndroidPhoneImpl;
import com.example.designPattern.adapter.ApplePhone;

/**
 * 类适配器
 *
 * @author yupan
 * @date 7/5/21 9:49 PM
 */
public class ClassAdapter extends AndroidPhoneImpl implements ApplePhone {

    @Override
    public void appleHeadset() {
        System.out.println("[类适配器]使用了耳机适配器");
        androidHeadset();
    }

    @Override
    public void appleCharger() {
        System.out.println("[类适配器]使用了充电器适配器");
        androidCharger();
    }
}
