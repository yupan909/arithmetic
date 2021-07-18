package com.example.designPattern.state;

/**
 * 弱光状态
 *
 * @author yupan
 * @date 7/18/21 12:29 PM
 */
public class LowState extends State {

    public LowState(Lamp lamp) {
        super(lamp);
        System.out.println("弱光");
    }

    @Override
    public void change() {
        // 变成"关闭"
        super.lamp.setState(new CloseState(super.lamp));
    }
}
