package com.example.datastructure.tree;

/**
 * 《二叉树》
 *      树有很多种，每个结点最多只能有两个子结点的成为二叉树，二叉树的结点分为左结点和右结点。
 *
 *  二叉树遍历：
 *      1、前序遍历：从二叉树的根结点出发，当第一次到达结点时就输出结点数据，按照先向左在向右的方向访问。
 *      2、中序遍历：从二叉树的根结点出发，当第二次到达结点时就输出结点数据，按照先向左在向右的方向访问。
 *      3、后序遍历：从二叉树的根结点出发，当第三次到达结点时就输出结点数据，按照先向左在向右的方向访问。
 *      4、层序遍历：层次遍历就是按照树的层次自上而下的遍历二叉树
 */
public class BinaryTree {

    private class Node {
        private String name;

        private Node left;

        private Node right;

        public Node(String name, Node left, Node right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" + "name=" + name + '}';
        }
    }

    /**
     * 初始化二叉树
     */
    public Node init() {
        Node E = new Node("E", null, null);
        Node D = new Node("D", null, null);
        Node B = new Node("B", D, E);
        Node C = new Node("C", null, null);
        Node A = new Node("A", B, C);
        return A;
    }

    /**
     * 前序遍历
     */
    public void beforeOrder(Node node) {
        if (node == null) {
            return;
        }
        // 1、输出结点
        System.out.printf("%s\t", node.name);
        // 2、前序遍历左子树
        beforeOrder(node.left);
        // 3、前序遍历右子树
        beforeOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void middleOrder(Node node) {
        if (node == null) {
            return;
        }
        // 1、中序遍历左子树
        middleOrder(node.left);
        // 2、输出结点
        System.out.printf("%s\t", node.name);
        // 3、中序遍历右子树
        middleOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void afterOrder(Node node) {
        if (node == null) {
            return;
        }
        // 1、后序遍历左子树
        afterOrder(node.left);
        // 2、后序遍历右子树
        afterOrder(node.right);
        // 3、输出结点
        System.out.printf("%s\t", node.name);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node node = binaryTree.init();
        // A B D E C
        System.out.print("前序遍历：");
        binaryTree.beforeOrder(node);
        System.out.println();
        // D B E A C
        System.out.print("中序遍历：");
        binaryTree.middleOrder(node);
        System.out.println();
        // D E B C A
        System.out.print("后序遍历：");
        binaryTree.afterOrder(node);
    }

}
