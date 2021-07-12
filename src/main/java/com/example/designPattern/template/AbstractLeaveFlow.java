package com.example.designPattern.template;

/**
 * 请假流程抽象模块
 *
 * @author yupan
 * @date 7/12/21 4:43 PM
 */
public abstract class AbstractLeaveFlow {

    /**
     * 请假申请
     */
    public final void apply() {
        // 请假类型
        leaveType();
        // 领导审批
        leader();
        // 备注
        remark();
        // 完结
        finish();
    }

    /**
     * 请假类型（父类默认实现，子类可以选择重写）
     */
    protected void leaveType() {
        System.out.println("请假");
    }

    /**
     * 领导审批（抽象方法，子类必须实现）
     */
    protected abstract void leader();

    /**
     * 备注（钩子方法：它默认不做任何事，子类可以视情况要不要覆盖它）
     */
    protected void remark() {

    }

    /**
     * 完结
     */
    private void finish() {
        System.out.println("流程完结！！！");
    }

}
