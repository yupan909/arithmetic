package com.example.designPattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体容器类
 *
 * @author yupan
 * @date 7/14/21 2:11 PM
 */
public class ConcreteAggregate<E> implements Aggregate<E> {

    /**
     * 模拟具体容器
     */
    private List<E> list = new ArrayList<>();

    @Override
    public void add(E e) {
        list.add(e);
    }

    @Override
    public void remove(E e) {
        list.remove(e);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(list);
    }
}
