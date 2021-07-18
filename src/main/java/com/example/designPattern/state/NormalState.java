package com.example.designPattern.state;

/**
 * 正常光状态
 *
 * @author yupan
 * @date 7/18/21 12:29 PM
 */
public class NormalState extends State {

    public NormalState(Lamp lamp) {
        super(lamp);
        System.out.println("正常光");
    }

    @Override
    public void change() {
        // 变成"强光"
        super.lamp.setState(new HighState(super.lamp));
    }
}
