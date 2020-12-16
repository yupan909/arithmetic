package com.example.datastructure.tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 《哈夫曼树》
 *      给定n个权值作为n个叶子结点，构造一棵二叉树，若该树的带权路径长度（WPL）达到最小，称这样的二叉树为最优二叉树，也称为哈夫曼树（赫夫曼树）。
 *
 *  基本概念：
 *  (1)路径：在一棵树中，从一个结点到另一个结点所经过的所有结点，被我们称为两个结点之间的路径。
 *  (2)路径长度：在一棵树中，从一个结点到另一个结点所经过的“边”的数量，被我们称为两个结点之间的路径长度。
 *  (3)结点的带权路径长度：树的每一个结点，都可以拥有自己的“权重”（Weight），权重在不同的算法当中可以起到不同的作用。
 *                       结点的带权路径长度，是指树的根结点到该结点的路径长度和该结点权重的乘积。
 *  (4)树的带权路径长度：在一棵树中，所有叶子结点的带权路径长度之和，被称为树的带权路径长度，也被简称为WPL。
 *
 *  哈夫曼树构建步骤：
 *      1、构建森林：把每一个叶子结点，都当做树一颗独立的树（只有根结点的树），这样就形成了一个森林，将全部叶子结点排序；
 *      2、取出根结点权值最小的两颗二叉树；
 *      3、组成一棵新的二叉树，该二叉树的根结点的权值是这两颗二叉树根结点权值之和；
 *      4、再将这颗新的二叉树的根结点权值跟未处理的结点权值再次排序，不断重复1、2、3、4的步骤，直到数列中所有结点都被处理，就得到一棵哈夫曼树；
 */
public class HuffmanTree {

    /**
     * 根结点
     */
    private TreeNode rootNode;

    /**
     * 结点类
     */
    private class TreeNode implements Comparable<TreeNode>{
        private Integer value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Integer value) {
            this.value = value;
        }

        public TreeNode(Integer value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * 前序遍历
         */
        public void beforeOrder() {
            if (this == null) {
                return;
            }
            // 1、输出结点
            System.out.printf("%s ", this.value);
            // 2、前序遍历左子树
            if (this.left != null) {
                this.left.beforeOrder();
            }
            // 3、前序遍历右子树
            if (this.right != null) {
                this.right.beforeOrder();
            }
        }

        @Override
        public int compareTo(TreeNode o) {
            return this.value - o.value;
        }
    }

    /**
     * 前序遍历
     */
    public void beforeOrderPrint() {
        if (rootNode == null) {
            System.out.println("前序遍历为空");
            return;
        }
        rootNode.beforeOrder();
    }

    /**
     * 构建哈夫曼树
     */
    public void buildHuffman(int arr[]) {
        // 创建存放结点的集合
        List<TreeNode> nodeList = new ArrayList<>();
        for (int v: arr) {
            nodeList.add(new TreeNode(v));
        }

        while (nodeList.size() > 1) {
            // 1、将集合按从小到大排序
            Collections.sort(nodeList);
            // 2、取出根结点权值最小的两颗二叉树
            TreeNode leftNode = nodeList.get(0);
            TreeNode rightNode = nodeList.get(1);
            // 3、组成一棵新的二叉树，该二叉树的根结点的权值是这两颗二叉树根结点权值之和
            TreeNode parentNode = new TreeNode((leftNode.value + rightNode.value), leftNode, rightNode);
            // 4、添加新的二叉树根结点
            nodeList.add(parentNode);
            // 5、移除刚刚处理过的两个二叉树根结点
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
        }
        rootNode = nodeList.get(0);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{13, 7, 8, 3, 29, 6, 1};
        HuffmanTree binaryTree = new HuffmanTree();
        // 构建哈夫曼树
        binaryTree.buildHuffman(arr);
        System.out.print("前序遍历哈夫曼树：");
        binaryTree.beforeOrderPrint();
    }

}
