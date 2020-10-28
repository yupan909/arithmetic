package com.example.datastructure.tree;

/**
 * 《顺序存储二叉树》
 *      二叉树的顺序存储结构就是使用一维数组存储二叉树中的结点，并且结点的存储位置，就是数组的下标索引。
 *  从数据存储来看，数组存储方式和树的存储方式可以相互转换，即数组可以转换成树，树也可以转换成数组
 *
 *           A[0]
 *         /     \                           0  1  2  3  4  5  6
 *        B[1]   C[2]              ---->     |  |  |  |  |  |  |
 *      /   \    /   \                      [A, B, C, D, E, F, G]
 *    D[3] E[4] F[5] G[6]
 *
 * 顺序存储二叉树的特点:
 *   (1)顺序二叉树通常只考虑完全二叉树
 *   (2)第n个元素的左子节点为 2 * n + 1
 *   (3)第n个元素的右子节点为 2 * n + 2
 *   (4)第n个元素的父节点为 (n-1) / 2
 * n：表示二叉树中的第几个元素(按0开始编号如图所示)
 *
 */
public class ArrayBinaryTree {

    private String[] arr;

    public ArrayBinaryTree(String[] arr) {
        this.arr = arr;
    }

    /**
     * 前序遍历
     */
    public void beforeOrder() {
        this.beforeOrder(0);
    }

    private void beforeOrder(int index) {
        if (index >= arr.length) {
            return;
        }
        // 1、输出结点
        System.out.printf("%s ", arr[index]);
        // 2、前序遍历左结点
        beforeOrder(2 * index + 1);
        // 3、前序遍历右结点
        beforeOrder(2 * index + 2);
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        // A  B  D  E  C  F  G
        tree.beforeOrder();
    }

}
