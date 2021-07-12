package com.example.designPattern.template;

/**
 * 《模板方法模式》
 *     模板方法模式又叫模板模式，模板方法模式在一个方法中定义一个算法骨架，并将某些步骤推迟到子类中实现，使得子类在不改变算法整体结构的情况下，重新定义算法中的某些步骤
 *
 *  角色介绍：
 *      1、AbstractTemplate（抽象模版）：定义一系列抽象方法，或者实现的方法，又或者是钩子方法。即：定义流程
 *      2、ConcreteTemplate（具体模版）：实现父类抽象方法，基于本身不同的模版业务逻辑，实现不同的业务逻辑代码。即：抽象方法实现相同，内部逻辑不同
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class TemplateTest {

    public static void main(String[] args) {
        // 年假流程
        AnnualLeaveFlow annualLeaveFlow = new AnnualLeaveFlow();
        annualLeaveFlow.apply();

        System.out.println();

        // 病假流程
        SickLeaveFlow sickLeaveFLow = new SickLeaveFlow();
        sickLeaveFLow.apply();

        System.out.println();

        // 其他流程
        OtherLeaveFlow otherLeaveFLow = new OtherLeaveFlow();
        otherLeaveFLow.apply();
    }
}
