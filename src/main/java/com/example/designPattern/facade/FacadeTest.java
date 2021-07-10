package com.example.designPattern.facade;

/**
 * 《外观模式》
 *      外观模式又叫作门面模式，是一种通过为多个复杂的子系统提供一个一致的接口，而使这些子系统更加容易被访问的模式。
 *  该模式对外有一个统一接口，外部应用程序不用关心内部子系统的具体细节，这样会大大降低应用程序的复杂度，提高了程序的可维护性。
 *
 *  优点：
 *      1、降低了子系统与客户端之间的耦合度，使得子系统的变化不会影响调用它的客户类。
 *      2、对客户屏蔽了子系统组件，减少了客户处理的对象数目，并使得子系统使用起来更加容易。
 *      3、降低了大型软件系统中的编译依赖性，简化了系统在不同平台之间的移植过程，因为编译一个子系统不会影响其他的子系统，也不会影响外观对象。
 *
 *  缺点：
 *      1、不能很好地限制客户使用子系统类，很容易带来未知风险。
 *      2、增加新的子系统可能需要修改外观类或客户端的源代码，违背了“开闭原则”。
 *
 *  角色介绍：
 *      1、外观（Facade）角色：为多个子系统对外提供一个共同的接口。
 *      2、子系统（Sub System）角色：实现系统的部分功能，客户可以通过外观角色访问它。
 *      3、客户（Client）角色：通过一个外观角色访问各个子系统的功能。
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class FacadeTest {

    public static void main(String[] args) {
        SmartController smartController = new SmartController();
        smartController.open();
        System.out.println("------------");
        smartController.close();
    }
}
