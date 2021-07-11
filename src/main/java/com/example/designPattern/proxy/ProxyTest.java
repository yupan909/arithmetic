package com.example.designPattern.proxy;

import com.example.designPattern.proxy.cglib.TeacherCglibProxy;
import com.example.designPattern.proxy.dynamic.TeacherDynamicProxy;
import com.example.designPattern.proxy.staticProxy.TeacherStaticProxy;

/**
 * 《代理模式》
 *      为某对象提供一种代理以控制对该对象的访问。即客户端通过代理间接地访问该对象，从而限制、增强或修改该对象的一些特性。
 *
 *  三种实现形式：
 *      1、静态代理：要求被代理对象需要实现接口或继承父类，我们的代理对象与被代理对象一起实现相同的接口或继承相同父类。
 *      2、JDK动态代理：通过Jdk自带的Proxy类来实现，原理是实现了被代理对象的接口。要求被代理对象需要实现接口，但是我们的代理对象不需要实现接口。
 *      3、Cglib动态代理：也叫子类代理，通过额外引用Cglib包来实现，原理是继承了被代理对象。对被代理对象没有什么要求，不需要实现接口或继承父类。
 *
 *  代理模式（静态）VS 装饰模式：
 *     相同点：都需要实现同一个接口或者继承同一个抽象类，并且代理角色和装饰角色都持有被代理角色和构件角色的引用。
 *     不同点：代理模式重点在于控制对象的行为，而装饰模式侧重于增加对象的职能。通俗的讲，它们俩根本的区别是目的性不一样，也就是使用场景。
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class ProxyTest {

    public static void main(String[] args) {
        Teacher teacher = new TeacherImpl();

        // 静态代理
        TeacherStaticProxy staticProxy = new TeacherStaticProxy(teacher);
        staticProxy.teach();

        System.out.println();

        // JDK动态代理
        TeacherDynamicProxy dynamicProxy = new TeacherDynamicProxy(teacher);
        dynamicProxy.getProxy().teach();

        System.out.println();

        // Cglib动态代理
        TeacherCglibProxy cglibProxy = new TeacherCglibProxy(teacher);
        cglibProxy.getProxy().teach();
    }
}
