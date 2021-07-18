package com.example.designPattern.state;

/**
 * 台灯
 *
 * @author yupan
 * @date 7/18/21 12:33 PM
 */
public class Lamp {

    private State state;

    public Lamp() {
        // 默认关闭状态
        this.state = new CloseState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void click() {
        this.state.change();
    }
}
