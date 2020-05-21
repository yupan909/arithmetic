package com.example.datastructure.stack;

import java.util.Scanner;

/**
 * 数组实现栈(先入后出，栈顶是可移动的一端，栈底是固定的一端)
 *
 * @author yupan@yijiupi.cn
 * @date 2020-05-18 21:42
 */
public class ArrayStack {

    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 数组存放数据
     */
    private int[] arr;

    /**
     * 栈顶指针
     */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 栈满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     */
    public void push(int o) {
        if (isFull()) {
            System.out.println("栈已满，无法入栈！");
            return;
        }
        arr[++top] = o;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空，无法出栈！");
        }
        int value = arr[top];
        top--;
        return value;
    }

    /**
     * 打印栈
     */
    public void list() {
        System.out.println("栈数据：");
        for (int i = top; i > -1; i--) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.print("【数组实现栈】入栈(h)、出栈(p)、打印栈(l)、退出(e)：");
            char key = scanner.next().charAt(0);
            switch (key) {
                case 'h':
                    System.out.print("入栈数据：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case 'p':
                    try {
                        System.out.println("出栈数据：" + arrayStack.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'l': arrayStack.list(); break;
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
