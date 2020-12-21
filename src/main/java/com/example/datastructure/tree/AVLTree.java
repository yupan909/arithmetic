package com.example.datastructure.tree;
/**
 * 《平衡二叉树》
 *      平衡二叉树也叫平衡二叉搜索树（Self-balancing binary search tree）又被称为AVL树（节点关系仍满足二叉排序树），
 *   是二叉搜索树的优化版本，可以保证查询效率较高。(左子节点，右子节点，顶点的关系仍要满足二叉排序树)
 *      平衡二叉树特点：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 *   平衡二叉树的常用实现方法有红黑树、AVL、替罪羊树、Treap、伸展树等。
 *
 *   平衡算法：
 *      1、单向左旋平衡处理
 *      2、单向右旋平衡处理
 *      3、双向旋转（先左后右）平衡处理
 *      4、双向旋转（先右后左）平衡处理
 *
 *   下图二叉排序树（BST）存在的问题分析
 *      1
 *       \
 *        2
 *         \
 *          3
 *           \
 *            4
 *      左子树全部为空，从形式上看，更像一个单链表。插入速度没有影响。查询速度明显降低(因为需要依次比较), 不能发挥BST的优势，
 *   因为每次还需要比较左子树，其查询速度比单链表还慢。解决方案-平衡二叉树(AVL)。
 */
public class AVLTree {

    /**
     * 根结点
     */
    private TreeNode rootNode;

    /**
     * 树结点
     */
    class TreeNode {
        /**
         * 结点值
         */
        private int value;
        /**
         * 左子结点
         */
        private TreeNode left;
        /**
         * 左子结点
         */
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        /**
         * 返回以该结点为根结点的树的高度
         */
        private int height() {
            return Math.max((this.left != null ? this.left.height() : 0), (this.right != null ? this.right.height() : 0)) + 1;
        }

        /**
         * 返回左子树的高度
         */
        private int leftHeight() {
            if (this.left == null) {
                return 0;
            }
            return this.left.height();
        }

        /**
         * 返回右子树的高度
         */
        private int rightHeight() {
            if (this.right == null) {
                return 0;
            }
            return this.right.height();
        }

        /**
         * 左旋转
         */
        private void leftRotate() {
            // 1、创建新的结点，以当前根结点的值
            TreeNode newNode = new TreeNode(this.value);
            // 2、把新的结点的左子结点设置成当前结点的左子结点
            newNode.left = this.left;
            // 3、把新的结点的右子结点设置成当前结点的右子结点的左子结点
            newNode.right = this.right.left;
            // 4、把当前结点的值替换成右子结点的值
            this.value = this.right.value;
            // 5、把当前结点的右子结点设置成当前结点右子结点的右子结点
            this.right = this.right.right;
            // 6、把当前结点的左子结点设置成新的结点
            this.left = newNode;
        }

        /**
         * 右旋转
         */
        private void rightRotate() {
            // 1、创建新的结点，以当前根结点的值
            TreeNode newNode = new TreeNode(this.value);
            // 2、把新的结点的右子结点设置成当前结点的右子结点
            newNode.right = this.right;
            // 3、把新的结点的左子结点设置成当前结点的左子结点的右子结点
            newNode.left = this.left.right;
            // 4、把当前结点的值替换成左子结点的值
            this.value = this.left.value;
            // 5、把当前结点的左子结点设置成当前结点左子结点的左子结点
            this.left = this.left.left;
            // 6、把当前结点的右子结点设置成新的结点
            this.right = newNode;
        }

        /**
         * 插入结点
         */
        private void addNode(TreeNode node) {
            // 插入结点小于当前结点，则往当前结点左子结点进行插入
            if (node.value < this.value) {
                if (this.left == null) {
                    // 左子结点为空时，则直接插入
                    this.left = node;
                } else {
                    // 左子结点不为空时，则往左子结点插入
                    this.left.addNode(node);
                }
            // 否则往当前结点右子结点进行插入
            } else {
                if (this.right == null) {
                    // 右子结点为空时，则直接插入
                    this.right = node;
                } else {
                    // 右子结点不为空时，则往右子结点插入
                    this.right.addNode(node);
                }
            }

            // 当添加完一个结点后，如果: (右子树的高度-左子树的高度) > 1 , 左旋转
            if(rightHeight() - leftHeight() > 1) {
                //如果它的右子树的左子树的高度大于它的右子树的右子树的高度
                if(right != null && right.leftHeight() > right.rightHeight()) {
                    //先对右子结点进行右旋转
                    right.rightRotate();
                    //然后在对当前结点进行左旋转
                    leftRotate(); //左旋转..
                } else {
                    //直接进行左旋转即可
                    leftRotate();
                }
            // 当添加完一个结点后，如果 (左子树的高度 - 右子树的高度) > 1, 右旋转
            } else if(leftHeight() - rightHeight() > 1) {
                //如果它的左子树的右子树高度大于它的左子树的高度
                if(left != null && left.rightHeight() > left.leftHeight()) {
                    //先对当前结点的左结点(左子树)->左旋转
                    left.leftRotate();
                    //再对当前结点进行右旋转
                    rightRotate();
                } else {
                    //直接进行右旋转即可
                    rightRotate();
                }
            }
        }

        /**
         * 中序遍历
         */
        private void middleOrder() {
            // 1、中序遍历左子树
            if (this.left != null) {
                this.left.middleOrder();
            }
            // 2、输出结点
            System.out.printf("%s ", this.value);
            // 3、中序遍历右子树
            if (this.right != null) {
                this.right.middleOrder();
            }
        }
    }

    /**
     * 中序遍历
     */
    public void middleOrderPrint() {
        if (rootNode == null) {
            return;
        }
        rootNode.middleOrder();
    }

    /**
     * 插入结点
     */
    public void add(int value) {
        TreeNode node = new TreeNode(value);
        // 根结点为空时，则插入结点直接当作根结点
        if (rootNode == null) {
            rootNode = node;
        } else {
            rootNode.addNode(node);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 3, 6, 5, 7, 8};
        int[] arr2 = {10, 12, 8, 9, 7, 6};
        int[] arr3 = {10, 11, 7, 6, 8, 9};
        //树1左旋转
        AVLTree avlTree1 = new AVLTree();
        for (int i = 0; i < arr1.length; i++) {
            avlTree1.add(arr1[i]);
        }
        System.out.println("左旋转平衡处理~~");
        System.out.println("树1的高度=" + avlTree1.rootNode.height());
        System.out.println("树1的左子树高度=" + avlTree1.rootNode.leftHeight());
        System.out.println("树1的右子树高度=" + avlTree1.rootNode.rightHeight());
        System.out.println();

        //树2右旋转
        AVLTree avlTree2 = new AVLTree();
        for (int i = 0; i < arr2.length; i++) {
            avlTree2.add(arr2[i]);
        }
        System.out.println("右旋转平衡处理~~");
        System.out.println("树2的高度=" + avlTree2.rootNode.height());
        System.out.println("树2的左子树高度=" + avlTree2.rootNode.leftHeight());
        System.out.println("树2的右子树高度=" + avlTree2.rootNode.rightHeight());
        System.out.println();

        //树3双旋转
        AVLTree avlTree3 = new AVLTree();
        for (int i = 0; i < arr3.length; i++) {
            avlTree3.add(arr3[i]);
        }
        System.out.println("双旋转平衡处理~~");
        System.out.println("树3的高度=" + avlTree3.rootNode.height());
        System.out.println("树3的左子树高度=" + avlTree3.rootNode.leftHeight());
        System.out.println("树3的右子树高度=" + avlTree3.rootNode.rightHeight());
        System.out.println();
    }

}
