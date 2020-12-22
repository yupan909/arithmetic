package com.example.datastructure.queue;

import java.util.Scanner;

/**
 * 数组实现队列
 *
 *     队列是一个有序列表，可以用数组或链表来实现，遵循先入先出的原则
 *
 * @author yupan@yijiupi.cn
 * @date 2020-04-22 14:37
 */
public class ArrayQueue implements Queue {

    /**
     *  队列容量（空余一个空间）
     */
    private int maxSize;

    /**
     * 队列头指针：指向队列的第一个元素
     */
    private int head;

    /**
     * 队列尾指针：指向队列的最后一个元素的后一个位置
     */
    private int tail;

    /**
     * 存放数据
     */
    private int[] arr;

    public ArrayQueue(int size) {
        maxSize = size + 1;
        arr = new int[maxSize];
        head = 0;
        tail = 0;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 判断队列是否已满
     * @return
     */
    @Override
    public boolean isFull() {
        return (tail + 1) % maxSize == head;
    }

    /**
     * 添加数据
     * @param o
     */
    @Override
    public void add(int o) {
        if (isFull()) {
            System.out.println("添加失败，队列已满！");
            return;
        }
        arr[tail] = o;
        tail = (tail + 1) % maxSize;
    }

    /**
     * 取出数据
     * @return
     */
    @Override
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("取出失败，队列已空！");
        }
        int getValue = arr[head];
        head = (head + 1) % maxSize;
        return getValue;
    }

    /**
     * 队列元素个数
     * @return
     */
    @Override
    public int size() {
        return (tail - head + maxSize) % maxSize;
    }

    /**
     * 显示队列数据
     */
    @Override
    public void show() {
        for (int i = head; i< head + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 显示队列头数据
     * @return
     */
    @Override
    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列头为空！");
        }
        return arr[head];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.print("【数组实现队列】显示队列(s)、添加数据(a)、取出数据(g)、队列头数据(h)、队列元素个数(l)、退出(e)：");
            char key = scanner.next().charAt(0);
            switch (key) {
                case 's': queue.show(); break;
                case 'a':
                    System.out.print("请输入一个数：");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g':
                    try {
                        System.out.println("取出的数据是：" + queue.get());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("头数据是：" + queue.showHead());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'l': System.out.println("队列元素个数是：" + queue.size()); break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default: break;
            }
        }
        System.out.println("程序退出。。。");
    }

}
