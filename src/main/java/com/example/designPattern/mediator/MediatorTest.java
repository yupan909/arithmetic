package com.example.designPattern.mediator;

/**
 * 《中介者模式》
 *     用一个中介者对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用，从而使耦合松散，而且可以独立地改变它们之间的交互。
 *
 *  角色介绍：
 *      1、抽象中介者（Mediator）角色：它是中介者的接口，提供了客户对象注册与转发客户对象信息的抽象方法。
 *      2、具体中介者（ConcreteMediator）角色：实现中介者接口，定义一个List来管理客户对象，协调各个客户角色之间的交互关系，因此它依赖于客户角色。
 *      3、抽象客户类（Customer）角色：定义客户类的接口，保存中介者对象，提供客户对象交互的抽象方法。
 *      4、具体客户类（Concrete Customer）角色：是抽象客户类的实现者，当需要与其他客户对象交互时，由中介者对象负责后续的交互。
 *
 *  优点：
 *     1、降低了对象之间的耦合性，使得对象易于独立地被复用。
 *     2、将对象间的一对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展。
 *
 *  缺点：
 *     1、中介者会膨胀的很大，而且逻辑复杂
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class MediatorTest {

    public static void main(String[] args) {
        // 中介者
        ConcreteMediator mediator = new ConcreteMediator();

        // 买方
        Buyer buyer1 = new Buyer("张三", mediator);
        Buyer buyer2 = new Buyer("李四", mediator);

        // 房东
        Seller seller1 = new Seller("老王", mediator);
        Seller seller2 = new Seller("老李", mediator);

        // 添加客户
        mediator.addCustomer(buyer1);
        mediator.addCustomer(buyer2);
        mediator.addCustomer(seller1);
        mediator.addCustomer(seller2);

        buyer1.need("我想买一个总价200w的房子");

        System.out.println();

        seller2.need("我打算出售一个三室一厅的房子");
    }
}
