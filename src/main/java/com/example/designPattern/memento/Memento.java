package com.example.designPattern.memento;

/**
 * 备忘录（存档）
 *
 * @author yupan
 * @date 7/16/21 6:28 PM
 */
public class Memento {

    /**
     * 关卡
     */
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Memento(int level) {
        this.level = level;
    }
}
