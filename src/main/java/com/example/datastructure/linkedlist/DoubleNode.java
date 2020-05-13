package com.example.datastructure.linkedlist;

/**
 * 双向链表节点
 *
 * @author yupan@yijiupi.cn
 * @date 2020-05-12 09:52
 */
public class DoubleNode {

    /**
     * 节点id
     */
    private Integer id;

    /**
     * 节点数据
     */
    private String data;

    /**
     * 指向上一个节点
     */
    private DoubleNode prev;

    /**
     * 指向下一个节点
      */
    private DoubleNode next;

    public DoubleNode(Integer id, String data) {
        this.id = id;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + "id=" + id + ", data='" + data + '\'' + '}';
    }
}
