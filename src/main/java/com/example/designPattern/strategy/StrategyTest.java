package com.example.designPattern.strategy;

/**
 * 《策略模式》
 *      定义一组算法，将每个算法都封装起来，并且使他们之间可以互换。
 *
 *  角色介绍：
 *      1、环境角色（Context）：持有一个Strategy的引用。也就是Context内部需要用到某种算法，在策略模式中这种算法是以无缝切换到另一种算法。
 *      2、抽象策略角色（Strategy）：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。
 *      3、具体策略角色（ConcreteStrategy）：包装了相关的算法或行为。
 *
 *  优点：
 *      1、算法可以自由切换，改一下策略很方便
 *      2、扩展性良好，增加一个策略，就多增加一个类就好了
 *
 *  缺点：
 *      1、策略类的数量增多，每一个策略都是一个类，复用的可能性很小、类数量增多
 *      2、上层模块必须知道有哪些策略，然后才能决定使用哪一个策略
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class StrategyTest {

    public static void main(String[] args) {
        // 加法策略
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 6 = " + context.execute(10, 6));
        // 减法策略
        context = new Context(new OperationSub());
        System.out.println("10 - 6 = " + context.execute(10, 6));
    }
}
