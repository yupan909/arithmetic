package com.example.designPattern.chain;

/**
 * CTO
 *
 * @author yupan
 * @date 7/18/21 2:19 PM
 */
public class CTOHandler extends Handler {

    @Override
    public void handleRequest(Integer days) {
        if (days > 2) {
            System.out.println("请假时间超过2天，等待CTO审批！");
        } else {
            handler.handleRequest(days);
        }
    }
}
