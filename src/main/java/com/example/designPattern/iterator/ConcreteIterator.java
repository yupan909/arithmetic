package com.example.designPattern.iterator;

import java.util.List;

/**
 * 具体迭代器类
 *
 * @author yupan
 * @date 7/14/21 1:53 PM
 */
public class ConcreteIterator<E> implements Iterator<E> {

    /**
     * 记录迭代位置
     */
    private int cursor = 0;

    private List<E> list;

    public ConcreteIterator(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return cursor != list.size();
    }

    @Override
    public E next() {
        E obj = null;
        if (hasNext()) {
            obj = list.get(cursor++);
        }
        return obj;
    }
}
