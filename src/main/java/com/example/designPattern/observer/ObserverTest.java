package com.example.designPattern.observer;

/**
 * 《观察者模式》
 *     定义对象间一种一对多的依赖关系，使得当每一个对象改变状态，则所有依赖于它的对象都会得到通知并自动更新。
 *     观察者模式的别名包括发布-订阅（Publish/Subscribe）模式、模型-视图（Model/View）模式、源-监听器（Source/Listener）模式或从属者（Dependents）模式。
 *
 *  角色介绍：
 *      1、主题（Subject）：被观察者，它是指被观察的对象。处理观察者的变化。当它的状态发生改变时，向它的各个观察者发出通知。
 *
 *      2、具体主题（ConcreteSubject）：是一个实现主题接口的类，有一个用来存放观察者对象的容器。
 *
 *      3、观察者（Observer）：根据主题中的更改而进行更新，观察者一般定义为接口，该接口声明了更新数据的方法 update()，因此又称为抽象观察者。
 *
 *      4、具体观察者（ConcreteObserver）：具体观察者的实现类。
 *
 *  优点：
 *     1、降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系，符合“开闭原则”的要求
 *
 *  缺点：
 *     1、目标与观察者之间的依赖关系并没有完全解除，而且有可能出现循环引用
 *     2、当观察者对象很多时，通知的发布会花费很多时间，影响程序的效率
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class ObserverTest {

    public static void main(String[] args) {
        // 观察者
        Observer observer1 = new ConcreteObserver("张三");
        Observer observer2 = new ConcreteObserver("李四");
        Observer observer3 = new ConcreteObserver("王五");

        // 主题
        Subject subject = new ConcreteSubject();
        subject.add(observer1);
        subject.add(observer2);
        subject.add(observer3);
        subject.notify("第一条朋友圈");

        System.out.println();

        subject.remove(observer3);
        subject.notify("第二条朋友圈");
    }
}
