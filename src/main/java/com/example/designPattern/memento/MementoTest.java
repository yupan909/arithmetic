package com.example.designPattern.memento;

/**
 * 《备忘录模式》
 *      在不破坏封闭的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以便恢复到原先保存的状态。
 *
 *  角色介绍：
 *      1、创建备忘录角色（Originator）：负责创建一个备忘录，可以记录、恢复自身的内部状态
 *
 *      2、备忘录角色（Memento）：用于存储Originator的内部状态，并且可以防止Originator以外的对象访问Memento
 *
 *      3、存储备忘录角色（Caretaker）: 负责存储备忘录，不能对备忘录的内容进行操作和访问，只能够将备忘录传递给其他对象
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class MementoTest {

    public static void main(String[] args) {
        // 存档管理类
        Caretaker caretaker = new Caretaker();

        // 打开游戏
        Game game = new Game();
        // 玩了第1关
        game.play();
        // 存档
        caretaker.archive(game.save());
        // 玩了第2关
        game.play();
        // 存档
        caretaker.archive(game.save());
        // 读档恢复游戏
        game.restore(caretaker.getMemento());
    }
}
