package com.example.designPattern.state;

/**
 * 关闭状态
 *
 * @author yupan
 * @date 7/18/21 12:29 PM
 */
public class CloseState extends State {

    public CloseState(Lamp lamp) {
        super(lamp);
        System.out.println("关闭");
    }

    @Override
    public void change() {
        // 变成"正常光"
        super.lamp.setState(new NormalState(super.lamp));
    }
}
