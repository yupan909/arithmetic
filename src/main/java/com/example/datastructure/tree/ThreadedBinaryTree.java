package com.example.datastructure.tree;


/**
 * 《线索二叉树》
 *      二叉树可以使用两种存储结构：顺序存储和二叉链表。在使用二叉链表的存储结构的过程中，会存在大量的空指针域，
 *  为了充分利用这些空指针域，引申出了“线索二叉树”
 *      可以通过充分利用二叉链表中的空指针域，存放节点在某种遍历方式下的前驱和后继节点的指针。
 *  我们把这种指向前驱和后继的指针成为线索，加上线索的二叉链表成为线索链表，对应的二叉树就成为“线索二叉树(Threaded Binary Tree)”
 *
 *  线索化：
 *      现将某结点的空指针域指向该结点的前驱后继，定义规则如下：
 *          1、若结点的左子树为空，则该结点的左孩子指针指向其前驱结点。
 *          2、若结点的右子树为空，则该结点的右孩子指针指向其后继结点。
 *      这种指向前驱和后继的指针称为线索。将一棵普通二叉树以某种次序遍历，并添加线索的过程称为线索化。
 *
 *  线索二叉树充分利用了指针空间，同时又便于寻找结点的前驱结点和后继结点。线索二叉树适用于经常需要遍历寻找结点前驱或者后继结点的二叉树。
 *
 */
public class ThreadedBinaryTree {

    /**
     * 根结点
     */
    private TreeNode rootNode;

    /**
     * 线索化时记录前一个节点
     */
    private TreeNode preNode;

    /**
     * 结点类
     */
    private class TreeNode {
        private String name;
        private TreeNode left;
        private TreeNode right;
        // 左指针域类型 0：指向子结点、1：指向前驱结点
        private int leftType;
        // 右指针域类型 0：指向子结点、1：指向后继结点
        private int rightType;


        public TreeNode(String name, TreeNode left, TreeNode right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" + "name='" + name + '\'' + '}';
        }
    }

    public ThreadedBinaryTree() {
        // 初始化二叉树
        //       A
        //      / \
        //     B   C
        //    / \
        //   D   E
        TreeNode E = new TreeNode("E", null, null);
        TreeNode D = new TreeNode("D", null, null);
        TreeNode B = new TreeNode("B", D, E);
        TreeNode C = new TreeNode("C", null, null);
        this.rootNode = new TreeNode("A", B, C);
    }

    /**
     * 中序线索化二叉树
     */
    public void middleThreadOrder() {
        if (rootNode == null) {
            return;
        }
        middleThreadOrder(rootNode);
    }

    private void middleThreadOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 1、处理左子树
        middleThreadOrder(node.left);
        // 2、线索化
        // 当前结点的左子结点为空时，指向前驱结点，且记录左指针域类型
        if (node.left == null) {
            node.left = preNode;
            node.leftType = 1;
        }
        // 前一结点的右子结点为空时，指向当前结点（后继结点），且记录右指针域类型
        if (preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.rightType = 1;
        }
        preNode = node;
        // 3、处理右子树
        middleThreadOrder(node.right);
    }

    /**
     * 中序遍历按后继方式线索化二叉树
     */
    public void middleOrderThreadListAfter() {
        TreeNode node = rootNode;
        while (node != null) {
            // 1、找中序遍历方式开始的节点
            while(node.left != null && node.leftType == 0) {
                node = node.left;
            }
            System.out.printf("%s ", node.name);
            // 2、如果右指针是线索，直接输出
            while (node.right != null && node.rightType == 1) {
                node = node.right;
                System.out.printf("%s ", node.name);
            }
            // 3、如果右指针不是线索，找到右子树开始的节点
            node = node.right;
        }
    }

    /**
     * 中序遍历按前驱方式线索化二叉树
     */
    public void middleOrderThreadListBefore() {
        TreeNode node = rootNode;
        while (node != null) {
            // 1、找中序遍历方式开始的节点
            while(node.right != null && node.rightType == 0) {
                node = node.right;
            }
            System.out.printf("%s ", node.name);
            // 2、如果左指针是线索，直接输出
            while (node.left != null && node.leftType == 1) {
                node = node.left;
                System.out.printf("%s ", node.name);
            }
            // 3、如果左指针不是线索，找到左子树开始的节点
            node = node.left;
        }
    }

    public static void main(String[] args) {
        ThreadedBinaryTree binaryTree = new ThreadedBinaryTree();
        // D B E A C
        binaryTree.middleThreadOrder();
        System.out.print("中序遍历按后继方式线索化二叉树：");
        binaryTree.middleOrderThreadListAfter();

        System.out.println();

        System.out.print("中序遍历按前驱方式线索化二叉树：");
        binaryTree.middleOrderThreadListBefore();
    }

}
