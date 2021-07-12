package com.example.designPattern.template;

/**
 * 病假流程
 *
 * @author yupan
 * @date 7/12/21 4:58 PM
 */
public class SickLeaveFlow extends AbstractLeaveFlow {

    @Override
    public void leaveType() {
        System.out.println("申请病假");
    }

    @Override
    protected void leader() {
        System.out.println("组长审批");
    }

    @Override
    public void remark() {
        System.out.println("两天以上需要开具医院证明！");
    }
}
