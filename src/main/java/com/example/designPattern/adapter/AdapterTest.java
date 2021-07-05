package com.example.designPattern.adapter;

import com.example.designPattern.adapter.classAdapter.ClassAdapter;
import com.example.designPattern.adapter.defaultAdapter.DefaultAdapter;
import com.example.designPattern.adapter.objectAdapter.ObjectAdapter;

/**
 * 《适配器模式》
 *     适配器模式指的是将一个类的接口转换成另一种接口，让原本接口不兼容的类可以兼容。
 *
 *  主要分为三类：类适配器模式、对象适配器模式、默认适配器模式
 *  1、类适配器模式：通过继承src类，实现dst类接口，完成src->dst的适配
 *  2、对象适配器模式：通过持有src类，实现dst类接口，完成src->dst的适配（使用组合关系来替代继承，推荐使用）
 *  3、默认适配器模式：当不需要全部实现接口提供的方法时，可先设计一个抽象类实现接口，并为该接口中每个方法提供
 *                   一个默认实现(空方法)，那么该抽象类的子类可有选择地覆盖父类的某些方法来实现需求，
 *                   适用于一个接口不想使用其所有的方法的情况。
 *
 *  包含三种角色：
 *  1、Target目标角色：该角色定义把其他类转换为何种接口，也就是我们的期望接口。
 *  2、Adaptee源角色：需要转换成目标角色的源角色，它是已经存在的、运行良好的类或对象，经过适配器角色的包装，它会成为一个崭新的角色。
 *  3、Adapter适配器角色：适配器模式的核心角色，其他两个角色都是已经存在的角色，而适配器角色是需要新建立的，
 *                      它的职责非常简单：把源角色通过继承或者类关联的方法转换为目标角色。
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class AdapterTest {

    public static void main(String[] args) {
        // 类适配器
        ApplePhone classAdapter = new ClassAdapter();
        classAdapter.appleHeadset();
        classAdapter.appleCharger();

        System.out.println();

        // 对象适配器
        ApplePhone objectAdapter = new ObjectAdapter(new AndroidPhoneImpl());
        objectAdapter.appleHeadset();
        objectAdapter.appleCharger();

        System.out.println();

        // 默认适配器
        ApplePhone defaultAdapter = new DefaultAdapter();
        defaultAdapter.appleHeadset();
        defaultAdapter.appleCharger();
    }
}
