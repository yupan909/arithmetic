package com.example.designPattern.state;

/**
 * 强光状态
 *
 * @author yupan
 * @date 7/18/21 12:29 PM
 */
public class HighState extends State {

    public HighState(Lamp lamp) {
        super(lamp);
        System.out.println("强光");
    }

    @Override
    public void change() {
        // 变成"弱光"
        super.lamp.setState(new LowState(super.lamp));
    }
}
