package com.example.designPattern.memento;

/**
 * 游戏类
 *
 * @author yupan
 * @date 7/16/21 6:23 PM
 */
public class Game {

    /**
     * 关卡
     */
    private int level;

    /**
     * 玩游戏
     */
    public void play () {
        System.out.println("恭喜你，通过第" + (++level) + "关" );
    }

    /**
     * 游戏存档
     */
    public Memento save() {
        return new Memento(level);
    }

    /**
     * 恢复游戏
     * @param memento
     */
    public void restore(Memento memento) {
        this.level = memento.getLevel();
        System.out.println("恢复游戏，当前是第" + this.level + "关");
    }

}
