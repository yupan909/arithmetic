package com.example.datastructure.linkedlist;

import java.util.Objects;
import java.util.Scanner;

/**
 * 双向链表
 *
 * @author yupan@yijiupi.cn
 * @date 2020-05-12 09:48
 */
public class DoubleLinkedList {

    /**
     * 头节点
     */
    private DoubleNode first;

    /**
     * 尾节点
     */
    private DoubleNode last;


    /**
     * 新增节点
     */
    public void add(DoubleNode node) {
        if (last == null) {
            first = node;
        } else {
            last.setNext(node);
            node.setPrev(last);
        }
        last = node;
    }

    /**
     * 修改节点
     * @param node
     */
    public void update(DoubleNode node) {
        if (first == null) {
            System.out.println("链表为空，修改失败！");
        }
        DoubleNode temp = first;
        // 遍历链表
        while(temp != null) {
            if (Objects.equals(temp.getId(), node.getId())) {
                temp.setData(node.getData());
            }
            temp = temp.getNext();
        }
    }

    /**
     * 删除节点
     */
    public void del(Integer id) {
        if (first == null) {
            System.out.println("链表为空，删除失败！");
        }
        DoubleNode temp = first;
        // 遍历链表
        while(temp != null) {
            // 找到待删除节点
            if (Objects.equals(temp.getId(), id)) {
                // 找到待删除节点的上一节点和下一个节点
                DoubleNode prevNode = temp.getPrev();
                DoubleNode nextNode = temp.getNext();
                // 表示待删除节点是头节点
                if (prevNode == null) {
                    first = nextNode;
                } else {
                    // 将上一节点和下一节点相连
                    prevNode.setNext(nextNode);
                    temp.setPrev(null);
                }
                // 表示待删除节点是尾节点
                if (nextNode == null) {
                    last = prevNode;
                } else {
                    nextNode.setPrev(prevNode);
                    temp.setNext(null);
                }
            }
            temp = temp.getNext();
        }
    }

    /**
     * 获取节点
     */
    public DoubleNode get(Integer id) {
        if (first == null) {
            return null;
        }
        DoubleNode temp = first;
        while(temp != null) {
            if (Objects.equals(temp.getId(), id)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    /**
     * 查看所有节点
     */
    public void list() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = first;
        while(temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.print("【双向链表】新增(1)、查找(2)、修改(3)、删除(4)、打印(5)、退出(0)：");
            Integer key = scanner.nextInt();
            switch (key) {
                case 1:
                    System.out.print("新增Id：");
                    int id = scanner.nextInt();
                    System.out.print("新增Data：");
                    String data = scanner.next();
                    DoubleNode node = new DoubleNode(id, data);
                    doubleLinkedList.add(node);
                    break;
                case 2:
                    System.out.print("查找Id：");
                    int id2 = scanner.nextInt();
                    System.out.println(doubleLinkedList.get(id2));
                    break;
                case 3:
                    System.out.print("修改Id：");
                    int updateId = scanner.nextInt();
                    System.out.print("修改Data：");
                    String updateData = scanner.next();
                    DoubleNode updateNode = new DoubleNode(updateId, updateData);
                    doubleLinkedList.update(updateNode);
                    break;
                case 4:
                    System.out.print("删除Id：");
                    int deleteId = scanner.nextInt();
                    doubleLinkedList.del(deleteId);
                    break;
                case 5:
                    doubleLinkedList.list();
                    break;
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

