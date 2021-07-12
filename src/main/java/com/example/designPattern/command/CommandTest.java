package com.example.designPattern.command;

/**
 * 《命令模式》
 *     命令模式是将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开，委派给不同的对象执行。
 *     命令模式可以将请求发送者和接收者完全解耦，发送者与接收者之间没有直接引用关系，发送请求的对象只需要知道如何发送请求，而不必知道如何完成请求。
 *
 *  角色介绍：
 *      1、Command (命令角色)：一个具体命令的抽象接口。
 *      2、ConcreteCommand（命令角色实现类）：具体命令本身并不实现具体的业务命令，而是会将调用委派给一个业务逻辑对象(命令接收者)去执行。
 *      3、Receiver（接收者角色）：命令传递到这里执行对应的操作。
 *      4、Invoker（调用者角色）：接收到命令，并执行命令，也就是命令的发动者和调用者。
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class CommandTest {

    public static void main(String[] args) {
        // 后厨工作人员（命令接收者）
        Worker cookWorker = new CookWorker();
        Worker counterWorker = new CounterWorker();
        // 下单（命令）
        Order mealOrder = new MealOrder(cookWorker);
        Order drinksOrder = new DrinksOrder(counterWorker);
        // 服务员（命令调用者）
        Waiter waiter = new Waiter();
        waiter.setOrder(mealOrder);
        waiter.call();

        System.out.println();

        waiter.setOrder(drinksOrder);
        waiter.call();
    }
}
