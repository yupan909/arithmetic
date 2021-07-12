package com.example.designPattern.template;

/**
 * 其他流程
 *
 * @author yupan
 * @date 7/12/21 4:58 PM
 */
public class OtherLeaveFlow extends AbstractLeaveFlow {

    @Override
    protected void leader() {
        System.out.println("领导审批");
    }
}
