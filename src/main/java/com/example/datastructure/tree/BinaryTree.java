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

        /**
         * 前序遍历
         */
        public void beforeOrder() {
            if (this == null) {
                return;
            }
            // 1、输出结点
            System.out.printf("%s ", this.name);
            // 2、前序遍历左子树
            if (this.left != null) {
                this.left.beforeOrder();
            }
            // 3、前序遍历右子树
            if (this.right != null) {
                this.right.beforeOrder();
            }
        }

        /**
         * 中序遍历
         */
        public void middleOrder() {
            if (this == null) {
                return;
            }
            // 1、中序遍历左子树
            if (this.left != null) {
                this.left.middleOrder();
            }
            // 2、输出结点
            System.out.printf("%s ", this.name);
            // 3、中序遍历右子树
            if (this.right != null) {
                this.right.middleOrder();
            }
        }

        /**
         * 后序遍历
         */
        public void afterOrder() {
            if (this == null) {
                return;
            }
            // 1、后序遍历左子树
            if (this.left != null) {
                this.left.afterOrder();
            }
            // 2、后序遍历右子树
            if (this.right != null) {
                this.right.afterOrder();
            }
            // 3、输出结点
            System.out.printf("%s ", this.name);
        }

        /**
         * 查找结点（前序遍历）
         */
        public boolean beforeOrderSearch(TreeNode node) {
            if (this == null) {
                return false;
            }
            // 1、比较查找值跟当前结点是否相等，如果相等则直接返回
            if (Objects.equals(node.name, this.name)) {
                return true;
            }
            // 2、当前结点没找到的话，则继续从左子树去查找
            boolean bool = false;
            if (this.left != null) {
                bool = this.left.beforeOrderSearch(node);
            }
            // 3、左子树没找到的话，则继续从右子树去查找
            if (!bool) {
                if (this.right != null) {
                    bool = this.right.beforeOrderSearch(node);
                }
            }
            return bool;
        }

        /**
         * 删除结点
         */
        public void deleteNode(TreeNode node){
            // 由于结点是单向的，根据父结点可以找到子结点，而子结点找不到父结点，所以需要判断子结点是不是要删除的结点
            if (this == null) {
                return;
            }
            // 1、如果左结点就是删除结点，则将左结点设为null，直接返回
            if (this.left != null && Objects.equals(this.left.name, node.name)) {
                this.left = null;
                return;
            }
            // 2、如果右结点就是删除结点，则将右结点设为null，直接返回
            if (this.right != null && Objects.equals(this.right.name, node.name)) {
                this.right = null;
                return;
            }
            // 3、找不到删除结点，则分别向左右结点递归
            this.left.deleteNode(node);
            this.right.deleteNode(node);
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
        rootNode.beforeOrder();
    }

    /**
     * 中序遍历
     */
    public void middleOrderPrint() {
        if (rootNode == null) {
            System.out.println("中序遍历为空");
            return;
        }
        rootNode.middleOrder();
    }

    /**
     * 后序遍历
     */
    public void afterOrderPrint() {
        if (rootNode == null) {
            System.out.println("空树遍历为空");
            return;
        }
        rootNode.afterOrder();
    }

    /**
     * 查找（前序遍历）
     */
    public Boolean beforeOrderSearch(String name) {
        if (rootNode == null) {
            return false;
        }
        TreeNode node = new TreeNode(name, null, null);
        return rootNode.beforeOrderSearch(node);
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
        TreeNode node = new TreeNode(name, null, null);
        rootNode.deleteNode(node);
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
