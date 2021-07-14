package com.example.designPattern.iterator;

/**
 * 迭代器接口
 *
 * @author yupan
 * @date 7/14/21 1:51 PM
 */
public interface Iterator<E> {

    /**
     * 是否还有下一个元素
     * @return
     */
    boolean hasNext();

    /**
     * 返回当前位置的元素并将位置移动到下一位
     * @return
     */
    E next();
}
