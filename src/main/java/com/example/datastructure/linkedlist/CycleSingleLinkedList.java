package com.example.datastructure.linkedlist;

/**
 * 单向循环链表
 *
 *  《解决约瑟夫问题》
 *       假设编号为1，2，3...n个人手拉手围坐在一圈，约定编号为k(1<= k <= n)的人开始报数，数到m的人出圈，
 *   他的下一位又从1开始报数，数到m的人又出圈，依次类推，直到剩余一个人即为胜出者，由此产生一个出圈编号的序列。
 *
 * @author yupan@yijiupi.cn
 * @date 2020-05-13 11:49
 */
public class CycleSingleLinkedList {

    /**
     * 游戏者节点
     */
    private class Node {

        private Integer no;

        private Node next;

        public Node(Integer no) {
            this.no = no;
        }
    }

    /**
     * 头节点
     */
    private Node first = null;

    /**
     * 链表中添加节点
     * @param num 节点个数
     */
    public void add(int num){
        if (num < 1) {
            throw new RuntimeException("节点数量必须大于0！");
        }
        Node curNode = first;
        for (int i = 1; i <= num; i++) {
            Node tempNode = new Node(i);
            if (i == 1) {
                first = tempNode;
            } else {
                curNode.next = tempNode;
                // 最后一个节点指向头节点，形成一个环形

                tempNode.next = first;
            }
            curNode = tempNode;
        }
    }

    /**
     * 打印所有节点
     */
    public void list(){
        if (first == null) {
            System.out.println("链表为空！");
            return;
        }
        Node curNode = first;
        while(curNode != null){
            System.out.println("节点：" + curNode.no);
            curNode = curNode.next;
            // 指向头节点时，表示遍历结束
            if (curNode == first) {
                break;
            }
        }
    }

    /**
     * 约瑟夫问题
     * @param n n个人围成圈
     * @param k 第k个人开始报数
     * @param m 数到m的人出圈
     */
    public void josephu(int n, int k, int m){
        // 1、组建n个人的圈
        add(n);

        // 2、定义一个辅助节点，记录出圈节点的前一个节点，用于删除操作
        Node helpNode = first;
        while (helpNode.next != first) {
            helpNode = helpNode.next;
        }

        // 3、找到第k个人(实际移动k-1次)
        for (int i = 0; i < (k - 1); i++) {
            first = first.next;
            helpNode = helpNode.next;
        }

        // 4、再往后数m（实际移动m-1次）
        while (helpNode != first) {
            for (int i = 0; i < (m - 1); i++) {
                first = first.next;
                helpNode = helpNode.next;
            }
            System.out.println("出圈的节点：" + first.no);
            // 出圈（删除节点）
            first = first.next;
            helpNode.next = first;
        }
        System.out.println("最后出圈的节点：" + first.no);
    }

    public static void main(String[] args) {
        CycleSingleLinkedList linkedList = new CycleSingleLinkedList();
        linkedList.josephu(5, 1, 2);
    }


}
