package com.example.designPattern.decorator;

/**
 * 《装饰模式》
 *      装饰模式又叫做包装模式，其功能是动态地给一个对象添加一些额外的职责。就增加功能来说，装饰模式相比生成子类更为灵活，是继承关系的一个替换方案。
 *
 *  应用场景：
 *      1、在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
 *      2、需要增加由一些基本功能的排列组合而产生的非常大量的功能，从而使继承关系变的不现实，使得子类数目呈爆炸性增长。
 *      3、当不能采用生成子类的方法进行扩充时。
 *
 *  角色介绍：
 *      1、Component抽象构件：Component是一个接口或者是抽象类，就是定义我们最核心的对象，也就是最原始的对象
 *       （在装饰模式中，必然有一个最基本、最核心、最原始的接口或抽象类充当Component抽象构件）。
 *
 *      2、ConcreteComponent具体构件角色：是Component的具体实现，要装饰的就是它。
 *
 *      3、Decorator装饰角色：一般是一个抽象类，实现Component接口或者抽象方法，它里面可不一定有抽象的方法呀，
 *        在它的属性里必然有一个private变量指向Component抽象构件（如果具体装饰角色只有一个，这个可以省略）。
 *
 *      4、ConcreteDecorator具体装饰角色：把你最核心的、最原始的、最基本的东西装饰成想要的东西。
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Beverage greenTea = new Lemon(new Mango(new GreenTea()));
        System.out.println(greenTea.desc() + " = 售价：" + greenTea.cost());

        Beverage redTea = new Mango(new Mango(new RedTea()));
        System.out.println(redTea.desc() + " = 售价：" + redTea.cost());
    }
}
