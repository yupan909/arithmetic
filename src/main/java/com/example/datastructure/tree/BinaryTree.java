package com.example.datastructure.tree;


import java.util.Objects;

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

    /**
     * 根结点
     */
    private TreeNode rootNode;

    /**
     * 结点类
     */
    private class TreeNode {
        private String name;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(String name, TreeNode left, TreeNode right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }
    }

    public BinaryTree() {
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
     * 前序遍历
     */
    public void beforeOrderPrint() {
        if (rootNode == null) {
            System.out.println("前序遍历为空");
            return;
        }
        beforeOrderPrint(rootNode);
    }

    private void beforeOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        // 1、输出结点
        System.out.printf("%s ", node.name);
        // 2、前序遍历左子树
        beforeOrderPrint(node.left);
        // 3、前序遍历右子树
        beforeOrderPrint(node.right);
    }

    /**
     * 中序遍历
     */
    public void middleOrderPrint() {
        if (rootNode == null) {
            System.out.println("中序遍历为空");
            return;
        }
        middleOrderPrint(rootNode);
    }

    private void middleOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        // 1、中序遍历左子树
        middleOrderPrint(node.left);
        // 2、输出结点
        System.out.printf("%s ", node.name);
        // 3、中序遍历右子树
        middleOrderPrint(node.right);
    }

    /**
     * 后序遍历
     */
    public void afterOrderPrint() {
        if (rootNode == null) {
            System.out.println("空树遍历为空");
            return;
        }
        afterOrderPrint(rootNode);
    }

    private void afterOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        // 1、后序遍历左子树
        afterOrderPrint(node.left);
        // 2、后序遍历右子树
        afterOrderPrint(node.right);
        // 3、输出结点
        System.out.printf("%s ", node.name);
    }

    /**
     * 查找（前序遍历）
     */
    public Boolean beforeOrderSearch(String name) {
        if (rootNode == null) {
            return false;
        }
        return beforeOrderSearch(rootNode, name);
    }

    private boolean beforeOrderSearch(TreeNode node, String name) {
        if (node == null) {
            return false;
        }
        // 1、比较查找值跟当前结点是否相等，如果相等则直接返回
        System.out.print("比较+1; ");
        if (Objects.equals(node.name, name)) {
            return true;
        }
        // 2、当前结点没找到的话，则继续从左子树去查找
        boolean bool = false;
        if (node.left != null) {
            bool = beforeOrderSearch(node.left, name);
        }
        // 3、左子树没找到的话，则继续从右子树去查找
        if (!bool) {
            if (node.right != null) {
                bool = beforeOrderSearch(node.right, name);
            }
        }
        return bool;
    }

    /**
     * 删除结点
     */
    public void deleteNode(String name){
        if (rootNode == null) {
            System.out.println("二叉树为空，无法删除");
            return;
        }
        // 删除根结点时，则直接将根结点设为null
        if (Objects.equals(rootNode.name, name)) {
            rootNode = null;
            return;
        }
        deleteNode(rootNode, name);
    }

    private void deleteNode(TreeNode node, String name){
        // 由于结点是单向的，根据父结点可以找到子结点，而子结点找不到父结点，所以需要判断子结点是不是要删除的结点
        if (node == null) {
            return;
        }
        // 1、如果左结点就是删除结点，则将左结点设为null，直接返回
        if (node.left != null && Objects.equals(node.left.name, name)) {
            node.left = null;
            return;
        }

        // 2、如果右结点就是删除结点，则将右结点设为null，直接返回
        if (node.right != null && Objects.equals(node.right.name, name)) {
            node.right = null;
            return;
        }
        // 3、找不到删除结点，则分别向左右结点递归
        deleteNode(node.left, name);
        deleteNode(node.right, name);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        // A B D E C
        System.out.print("前序遍历：");
        binaryTree.beforeOrderPrint();
        System.out.println();

        // D B E A C
        System.out.print("中序遍历：");
        binaryTree.middleOrderPrint();
        System.out.println();

        // D E B C A
        System.out.print("后序遍历：");
        binaryTree.afterOrderPrint();
        System.out.println();

        System.out.println("查找(前序遍历)：" + binaryTree.beforeOrderSearch("D"));

        binaryTree.deleteNode("C");
        System.out.print("删除结点后：");
        binaryTree.beforeOrderPrint();

    }

}
