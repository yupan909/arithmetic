package com.example.designPattern.builder;

/**
 * 《建造者模式》
 *     1、建造者模式(Builder Pattern)又 叫生成器模式，是一种对象构建模式。它可以将复杂对象的建造过程抽象出来(抽象类别)，
 * 使这个抽象过程的不同实现方法可以构造出不同表现(属性)的对象。
 *     2、建造者模式是一步一步创建一个复杂的对象，它允许用户只通过指定复杂对象的类型和内容就可以构建它们，
 * 用户不需要知道内部的具体构建细节。
 *
 *  建造者模式的四个角色：
 *     Product(产品类) :一个具体的产品类对象
 *     Builder(抽象建造者类)：为我们需要生成的类对象，构建不同的模块属性，即：公开构建产品类的属性，隐藏产品类的其他功能
 *     ConcreteBuilder(具体建造者类)：实现我们要生成的类对象
 *     Director(导演类)：确定构建我们的类对象具体有哪些模块属性，在实际应用中可以不需要这个角色，直接通过client处理
 *
 *  抽象工厂模式 VS 建造者模式
 *      抽象工厂模式实现对产品家族的创建，一个产品家族是这样的一系列产品：具有不同分类维度的产品组合，
 *   采用抽象工厂模式不需要关心构建过程，只关心什么产品由什么工厂生产即可。
 *      而建造者模式则是要求按照指定的蓝图建造产品，它的主要目的是通过组装零配件而产生-一个新产品
 *
 * @author yupan
 * @date 7/2/21 11:16 AM
 */
public class BuilderTest {

    public static void main(String[] args){
        // 建造苹果电脑
        AbstractComputerBuilder macbookBuilder = new MacbookComputerBuilder();
        ComputerSeller computerSeller = new ComputerSeller(macbookBuilder);
        Computer macbook = computerSeller.bulidComputer();
        System.out.println("苹果电脑：" + macbook);

        // 建造联想电脑
        AbstractComputerBuilder lenoveBuilder = new LenovoComputerBuilder();
        ComputerSeller computerSeller2 = new ComputerSeller(lenoveBuilder);
        Computer lenovo = computerSeller2.bulidComputer();
        System.out.println("联想电脑：" + lenovo);
    }
}
