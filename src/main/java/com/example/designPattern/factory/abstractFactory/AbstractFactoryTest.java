package com.example.designPattern.factory.abstractFactory;

import com.example.designPattern.factory.Ball;

/**
 * 《抽象工厂模式》
 *     定义了一个接口用于创建相关或有依赖关系的对象簇，而无需指明具体的类
 *  抽象工厂模式可以将简单工厂模式和工厂方法模式进行整合。
 *
 *  优点：
 *      1、代码解耦
 *      2、可以实现多个产品族(相关联产品组成的家族)，相对工厂方法模式的单个产品，可以满足更多的生产需求
 *      3、很好的满足OCP开放封闭原则
 *
 *  缺点：
 *      1.扩展产品族相当麻烦，而且扩展产品族会违反OCP，因为要修改所有的工厂
 *      2.由于抽象工厂模式是工厂方法模式的扩展，总体的来说很笨重
 *
 *  三种工厂模式的总结:
 *      1、简单工厂模式最大的特点就是工厂内有具体的逻辑去判断生成什么产品，将类的实例化交给了工厂，这样当我们需要什么产品只需要修改客户端的调用而不需要去修改工厂，
 *   对于客户端来说降低了与具体产品的依赖
 *      2、工厂方法模式是简单工厂的扩展，工厂方法模式把原先简单工厂中的实现那个类的逻辑判断交给了客户端，如果像添加功能只需要修改客户和添加具体的功能，
 *   不用去修改之前的类。
 *      3、抽象工厂模式进一步扩展了工厂方法模式，它把原先的工厂方法模式中只能有一个抽象产品不能添加产品族的缺点克服了，抽象工厂模式不仅仅遵循了OCP原则(对扩展开放，对修改关闭)，
 *   而且可以添加更多产品(抽象产品),具体工厂也不仅仅可以生成单一产品，而是生成一组产品，抽象工厂也是声明一组产品，对应扩展更加灵活，但是要是扩展族系就会很笨重。
 *
 * @author yupan
 * @date 7/4/21 2:29 PM
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        // 耐克体育工厂
        SportFactory nikeSportFactory = new NikeSportFactory();
        System.out.println("耐克体育工厂:");
        Ball nikeBall = nikeSportFactory.createBall();
        nikeBall.play();
        Shirt nikeShirt = nikeSportFactory.createShirt();
        nikeShirt.show();

        // 李宁体育工厂
        SportFactory liNingSportFactory = new LiNingSportFactory();
        System.out.println("李宁体育工厂:");
        Ball liNingBall = liNingSportFactory.createBall();
        liNingBall.play();
        Shirt liNingShirt = liNingSportFactory.createShirt();
        liNingShirt.show();
    }
}
