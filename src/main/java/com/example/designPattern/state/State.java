package com.example.designPattern.state;

/**
 * 抽象状态类
 *
 * @author yupan
 * @date 7/18/21 12:27 PM
 */
public abstract class State {

    /**
     * 台灯
     */
    protected Lamp lamp;

    public State(Lamp lamp) {
        this.lamp = lamp;
    }

    /**
     * 切换
     */
    abstract void change();
}
