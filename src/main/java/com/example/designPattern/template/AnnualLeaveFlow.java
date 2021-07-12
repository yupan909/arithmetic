package com.example.designPattern.template;

/**
 * 年假流程
 *
 * @author yupan
 * @date 7/12/21 4:57 PM
 */
public class AnnualLeaveFlow extends AbstractLeaveFlow {

    @Override
    public void leaveType() {
        System.out.println("申请年假");
    }

    @Override
    protected void leader() {
        System.out.println("部门经理审批");
    }

}
