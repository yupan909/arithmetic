package com.example.designPattern.iterator;

/**
 * 容器接口
 *
 * @author yupan
 * @date 7/14/21 2:08 PM
 */
public interface Aggregate<E> {

    /**
     * 添加
     * @param e
     */
    void add(E e);

    /**
     * 删除
     * @param e
     */
    void remove(E e);

    /**
     * 获取迭代器
     * @return
     */
    Iterator<E> iterator();
}
