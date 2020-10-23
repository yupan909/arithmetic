package com.example.datastructure.linkedlist;

import java.util.Objects;
import java.util.Scanner;

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
     */
    public void del(Integer id) {
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
            if (Objects.equals(temp.getNext().getId(), id)) {
                temp.setNext(temp.getNext().getNext());
            }
            temp = temp.getNext();
        }
    }

    /**
     * 获取节点
     */
    public Node get(Integer id) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return null;
        }
        Node temp = head.getNext();
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
     * 反向打印
     */
    public void reversePrint() {
        reversePrint2(head.getNext());
    }

    /**
     * 反向输出(递归)
     */
    private void reversePrint2(Node node) {
        if (node != null) {
            reversePrint2(node.getNext());
            System.out.println(node);
        }
    }

    public static void main(String[] args) {
        LinkedList linked = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.print("【单向链表】新增(1)、查找(2)、修改(3)、删除(4)、反转(5)、反向打印(6)、打印(7)、退出(0)：");
            Integer key = scanner.nextInt();
            switch (key) {
                case 1:
                    System.out.print("新增Id：");
                    int id = scanner.nextInt();
                    System.out.print("新增Data：");
                    String data = scanner.next();
                    Node node = new Node(id, data);
                    linked.add(node);
                    break;
                case 2:
                    System.out.print("查找Id：");
                    int id2 = scanner.nextInt();
                    System.out.println(linked.get(id2));
                    break;
                case 3:
                    System.out.print("修改Id：");
                    int updateId = scanner.nextInt();
                    System.out.print("修改Data：");
                    String updateData = scanner.next();
                    Node updateNode = new Node(updateId, updateData);
                    linked.update(updateNode);
                    break;
                case 4:
                    System.out.print("删除Id：");
                    int deleteId = scanner.nextInt();
                    linked.del(deleteId);
                    break;
                case 5:
                    linked.reverse();
                    System.out.println("反转完成！");
                    break;
                case 6:
                    linked.reversePrint();
                    break;
                case 7:
                    linked.list();
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



