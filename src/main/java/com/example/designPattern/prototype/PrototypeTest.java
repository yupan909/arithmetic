package com.example.designPattern.prototype;

/**
 * 《原型模式》
 *      用原型实例指定创建对象的种类，并且通过拷贝这些原型，创建新的对象
 *
 *  需要实现Cloneable可以选择重写clone()方法。
 *  clone分为浅克隆和深克隆。浅克隆只是克隆引用，对象还是一个；深克隆是对象也新创建了一个。
 *
 *  深拷贝有两种实现方式:
 *     1、重写clone方法来实现深拷贝
 *     2、通过对象序列化实现深拷贝(推荐)
 *
 * @author yupan
 * @date 7/2/21 11:16 AM
 */
public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep friend = new Sheep("美洋洋", 2, null);
        Sheep sheep = new Sheep("喜洋洋", 1, friend);
        Sheep cloneSheep = (Sheep) sheep.clone();
        System.out.println("sheep == cloneSheep：" + (sheep == cloneSheep));
        System.out.println("sheep.friend == cloneSheep.friend：" + (sheep.getFriend() == cloneSheep.getFriend()));
    }
}
