package com.example.designPattern.memento;

/**
 * 负责管理备忘者类
 *
 * @author yupan
 * @date 7/16/21 7:24 PM
 */
public class Caretaker {

    private Memento memento;

    /**
     * 存档
     * @param memento
     */
    public void archive(Memento memento) {
        System.out.println("存档。。。");
        this.memento = memento;
    }

    /**
     * 获取存档
     * @return
     */
    public Memento getMemento() {
        return this.memento;
    }
}
