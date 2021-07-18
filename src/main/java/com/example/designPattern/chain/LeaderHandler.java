package com.example.designPattern.chain;

/**
 * 组长
 *
 * @author yupan
 * @date 7/18/21 2:19 PM
 */
public class LeaderHandler extends Handler {

    @Override
    public void handleRequest(Integer days) {
        if (days == 1) {
            System.out.println("请假时间为1天，等待组长审批！");
        } else {
            handler.handleRequest(days);
        }
    }
}
