package com.example.designPattern.chain;

/**
 * 项目经理
 *
 * @author yupan
 * @date 7/18/21 2:19 PM
 */
public class ManagerHandler extends Handler {

    @Override
    public void handleRequest(Integer days) {
        if (days == 2) {
            System.out.println("请假时间为2天，等待项目经理审批！");
        } else {
            handler.handleRequest(days);
        }
    }
}
