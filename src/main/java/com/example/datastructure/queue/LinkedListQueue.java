package com.example.datastructure.queue;

import java.util.Scanner;

/**
 * 链表实现队列
 *
 *     队列是一个有序列表，可以用数组或链表来实现，遵循先入先出的原则
 *
 * @author yupan@yijiupi.cn
 * @date 2020-04-22 14:37
 */
public class LinkedListQueue {

    /**
     * 队列单个节点
     */
    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + '}';
        }
    }

    /**
     *  队列容量
     */
    private int maxSize;

    /**
     * 队列头指针：指向队列的第一个节点
     */
    private Node head;

    /**
     * 队列尾指针：指向队列的最后一个节点
     */
    private Node tail;

    /**
     * 队列元素个数
     */
    private int realSize;

    public LinkedListQueue(int size) {
        this.maxSize = size;
        this.realSize = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return realSize == 0;
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull() {
        return realSize == maxSize;
    }

    /**
     * 添加数据
     * @param o
     */
    public void add(int o) {
        if (isFull()) {
            System.out.println("添加失败，队列已满！");
            return;
        }
        Node node = new Node(o);
        // 如果队列为空
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        realSize++;
    }

    /**
     * 取出数据
     * @return
     */
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("取出失败，队列已空！");
        }
        int tmp = head.data;
        head = head.next;
        realSize--;
        // 队列为空时，队列尾指针置为null
        if (realSize == 0) {
            tail = null;
        }
        return tmp;
    }

    /**
     * 队列元素个数
     * @return
     */
    public int size() {
        return realSize;
    }

    /**
     * 显示队列数据
     */
    public void show() {
        if (head == null) {
            System.out.println("队列为空！");
            return;
        }
        for(Node temp = head; temp != null; temp = temp.next) {
            System.out.println(temp);
        }
    }

    /**
     * 显示队列头数据
     * @return
     */
    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列头为空！");
        }
        return head.data;
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue(3);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while (loop) {
            System.out.print("【链表实现队列】显示队列(s)、添加数据(a)、取出数据(g)、队列头数据(h)、队列元素个数(l)、退出(e)：");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's': queue.show(); break;
                case 'a':
                    System.out.print("请输入一个数：");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'h':
                    try {
                        System.out.println("头数据是：" + queue.showHead());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println("取出的数据是：" + queue.get());
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
