package com.example.datastructure.hash;

import com.example.datastructure.linkedlist.LinkedList;
import com.example.datastructure.linkedlist.Node;

import java.util.Scanner;

/**
 * 哈希表
 *
 * @author yupan
 * @date 2020-10-22 17:44
 */
public class HashTable {

    /**
     * 链表数组
     */
    private LinkedList[] linkedList;

    /**
     * 默认大小
     */
    private int size = 10;

    public HashTable() {
        this.linkedList = new LinkedList[size];
        for(int i = 0; i< this.linkedList.length; i++) {
            this.linkedList[i] = new LinkedList();
        }
    }

    /**
     * 哈希函数
     * @return
     */
    private int getHash(Integer id) {
        return id % 10;
    }

    /**
     * 添加元素
     * @param node
     */
    public void add(Node node) {
        // 获取对应的索引
        int hash = getHash(node.getId());
        linkedList[hash].add(node);
    }

    /**
     * 获取元素
     */
    public Node get(Integer id) {
        // 获取对应的索引
        int hash = getHash(id);
        return linkedList[hash].get(id);
    }

    /**
     * 打印所有元素
     */
    public void list() {
        for(int i = 0; i< this.linkedList.length; i++) {
            System.out.println("第" + i + "号链表");
            this.linkedList[i].list();
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.print("【哈希表】添加(1)、查找(2)、打印(3)、退出(0)：");
            Integer key = scanner.nextInt();
            switch (key) {
                case 1:
                    System.out.print("Id：");
                    int id = scanner.nextInt();
                    System.out.print("Name：");
                    String name = scanner.next();
                    Node node = new Node(id, name);
                    hashTable.add(node);
                    break;
                case 2:
                    System.out.print("查找的Id：");
                    int id2 = scanner.nextInt();
                    Node node2 = hashTable.get(id2);
                    System.out.println(node2);
                    break;
                case 3: hashTable.list(); break;
                case 0:
                    scanner.close();
                    loop = false;
                    break;
                default: break;
            }
        }
        System.out.println("程序退出。。。");
    }

}
