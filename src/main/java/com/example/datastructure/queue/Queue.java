package com.example.datastructure.queue;

/**
 * 队列
 *
 * @author yupan
 * @date 12/22/20 4:52 PM
 */
public interface Queue {

    /**
     * 判断队列是否为空
     */
    boolean isEmpty();

    /**
     * 判断队列是否已满
     */
    boolean isFull();

    /**
     * 添加数据
     */
    void add(int o);

    /**
     * 取出数据
     */
    int get();

    /**
     * 队列元素个数
     */
    int size();

    /**
     * 显示队列数据
     */
    void show();

    /**
     * 显示队列头数据
     */
    int showHead();

}
