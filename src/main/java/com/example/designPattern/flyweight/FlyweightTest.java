package com.example.designPattern.flyweight;

/**
 * 《享元模式》
 *      又称为蝇量模式，即运用共享技术有效的支持大量细粒度的对象。
 *
 *      享元模式有点类似于单例模式，都是只生成一个对象被共享使用。享元模式主要目的就是让多个对象实现共享，减少不会要额内存消耗，
 *  将多个对同一对象的访问集中起来，不必为每个访问者创建一个单独的对象，以此来降低内存的消耗。
 *
 *  外部状态和内部状态：
 *      1、内部状态是可以共享的,存储在享元内部，不会随环境的改变而有所不同.
 *      2、外部状态是不可以共享的，它随环境的改变而改变的，因此外部状态是由客户端来保持（因为环境的变化是由客户端引起的）.
 *
 *  角色介绍：
 *      1、抽象享元角色(Flyweight) ：为具体享元角色规定了必须实现的方法，而外部状态就是以参数的形式通过此方法传入。可以由抽象类、接口来担当。
 *      2、具体享元角色(ConcreteFlyweight) ：实现抽象角色规定的方法。如果存在内部状态，就负责为内部状态提供存储空间。
 *      3、享元工厂角色(FlyweightFactory) ：负责创建和管理享元角色。要想达到共享的目的，这个角色的实现是关键！
 *      4、客户端角色(Client) ：维护对所有享元对象的引用，而且还需要存储对应的外蕴状态
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class FlyweightTest {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("长方形");
        Shape shape2 = shapeFactory.getShape("正方形");
        Shape shape3 = shapeFactory.getShape("圆形");
        Shape shape4 = shapeFactory.getShape("长方形");

        shape1.show(new Color("绿色"));
        shape2.show(new Color("白色"));
        shape3.show(new Color("篮色"));
        shape4.show(new Color("红色"));

        System.out.println("对象总数：" + shapeFactory.size());
    }
}
