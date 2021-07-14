package com.example.designPattern.iterator;

/**
 * 《迭代器模式》
 *     提供一种方法顺序访问一个容器对象中的各个元素，而又不需要暴露该对象的内部表示。
 *
 *  角色介绍：
 *      1、迭代器接口（Iterator）: 负责定义、访问和遍历元素的接口。
 *      2、具体迭代器类（ConcreteIterator）: 目的主要是实现迭代器接口，并记录遍历的当前位置。
 *      3、容器接口（Aggregate）: 负责提供创建具体迭代器角色的接口。
 *      4、具体容器类（ConcreteAggregate）: 具体迭代器角色与该容器相关联。
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class IteratorTest {

    public static void main(String[] args) {
        // 创建容器
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add(1);
        aggregate.add(2);
        aggregate.add(3);
        aggregate.add(4);

        // 获取迭代器
        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println("迭代：" + iterator.next());
        }
    }
}
