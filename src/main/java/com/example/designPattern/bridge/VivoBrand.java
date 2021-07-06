package com.example.designPattern.bridge;

/**
 * vivo手机
 *
 * @author yupan
 * @date 7/6/21 6:51 PM
 */
public class VivoBrand implements Brand{

    @Override
    public String explain() {
        return "vivo";
    }
}
