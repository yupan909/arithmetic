package com.example.datastructure.linkedlist;

import java.util.Objects;

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
     * @param node
     */
    public void del(DoubleNode node) {
        if (first == null) {
            System.out.println("链表为空，删除失败！");
        }
        DoubleNode temp = first;
        // 遍历链表
        while(temp != null) {
            // 找到待删除节点
            if (Objects.equals(temp.getId(), node.getId())) {
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
        DoubleNode node1 = new DoubleNode(1, "AA");
        DoubleNode node2 = new DoubleNode(2, "BB");
        DoubleNode node3 = new DoubleNode(3, "CC");
        DoubleNode node4 = new DoubleNode(4, "DD");

        System.out.println("====新增节点：");
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        doubleLinkedList.list();

        System.out.println("====修改节点：");
        DoubleNode node5 = new DoubleNode(1, "EE");
        doubleLinkedList.update(node5);
        doubleLinkedList.list();

        System.out.println("====删除节点：");
        doubleLinkedList.del(node4);
        doubleLinkedList.list();
    }

}

