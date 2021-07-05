package com.example.designPattern.adapter.defaultAdapter;

/**
 * 默认适配器
 *
 * @author yupan
 * @date 7/5/21 10:11 PM
 */
public class DefaultAdapter extends AbstractDefaultAdapter{

    @Override
    public void appleHeadset() {
        System.out.println("[默认适配器]只适配了耳机");
    }
}
