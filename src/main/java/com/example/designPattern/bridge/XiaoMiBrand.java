package com.example.designPattern.bridge;

/**
 * 小米手机
 *
 * @author yupan
 * @date 7/6/21 6:51 PM
 */
public class XiaoMiBrand implements Brand{

    @Override
    public String explain() {
        return "小米";
    }
}
