package com.example.datastructure.linkedlist;

import java.util.Objects;

/**
 * 单向链表
 *
 * @author yupan@yijiupi.cn
 * @date 2020-04-23 16:33
 */
public class LinkedList {

    /**
     * 初始化一个头节点
     */
    private Node head = new Node(null, null);

    /**
     * 新增节点
     */
    public void add(Node node) {
        Node temp = head;
        // 遍历链表，找到最后一个节点
        while(true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        // 当退出while循环时，temp指向了最后一个节点
        temp.setNext(node);
    }

    /**
     * 修改节点
     * @param node
     */
    public void update(Node node) {
        if (head.getNext() == null) {
            System.out.println("链表为空，修改失败！");
        }
        Node temp = head.getNext();
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
    public void del(Node node) {
        if (head.getNext() == null) {
            System.out.println("链表为空，删除失败！");
        }
        Node temp = head;
        // 遍历链表
        while(temp != null) {
            // 表示到链表最后，直接退出
            if (temp.getNext() == null) {
                break;
            }

            // 找到待删除节点的前一个节点
            if (Objects.equals(temp.getNext().getId(), node.getId())) {
                temp.setNext(temp.getNext().getNext());
            }
            temp = temp.getNext();
        }
    }

    /**
     * 查看所有节点
     */
    public void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.getNext();
        while(temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    /**
     * 链表节点反转
     * @return
     */
    public void reverse() {
        if (head.getNext() == null) {
            return;
        }
        LinkedList tempList = new LinkedList();
        // 遍历原链表，依次放在临时链表的最前面
        Node temp = head.getNext();
        while(temp != null) {
            // 1、首先找到原链表当前节点的下一个节点
            Node nextNode = temp.getNext();
            // 2、把新链表的第一个节点插入到当前节点的后面
            temp.setNext(tempList.head.getNext());
            // 3、把当前节点插入新链表的第一个节点中
            tempList.head.setNext(temp);
            // 4、继续寻找下一个节点
            temp = nextNode;
        }
        head.setNext(tempList.head.getNext());
    }

    /**
     * 反向输出(递归)
     */
    public void reversePrint(Node node) {
        if (node != null) {
            reversePrint(node.getNext());
            System.out.println(node);
        }
    }

    public static void main(String[] args) {
        LinkedList linked = new LinkedList();
        Node node1 = new Node(1, "A");
        Node node2 = new Node(2, "B");
        Node node3 = new Node(3, "C");
        Node node4 = new Node(4, "D");

        System.out.println("====新增节点：");
        linked.add(node1);
        linked.add(node2);
        linked.add(node3);
        linked.add(node4);
        linked.list();

        System.out.println("====反向打印：");
        linked.reversePrint(linked.head.getNext());

        System.out.println("====反转节点：");
        linked.reverse();
        linked.list();

        System.out.println("====修改节点：");
        Node node5 = new Node(1, "E");
        linked.update(node5);
        linked.list();

        System.out.println("====删除节点：");
        linked.del(node1);
        linked.del(node4);
        linked.list();
    }
}



