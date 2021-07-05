package com.example.designPattern.adapter.objectAdapter;

import com.example.designPattern.adapter.AndroidPhone;
import com.example.designPattern.adapter.ApplePhone;

/**
 * 对象适配器
 *
 * @author yupan
 * @date 7/5/21 9:59 PM
 */
public class ObjectAdapter implements ApplePhone {

    private AndroidPhone androidPhone;

    public ObjectAdapter(AndroidPhone androidPhone) {
        this.androidPhone = androidPhone;
    }

    @Override
    public void appleHeadset() {
        System.out.println("[对象适配器]使用了耳机适配器");
        androidPhone.androidHeadset();
    }

    @Override
    public void appleCharger() {
        System.out.println("[对象适配器]使用了耳机适配器");
        androidPhone.androidCharger();
    }
}
