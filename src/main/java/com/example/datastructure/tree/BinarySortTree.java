package com.example.datastructure.tree;

import java.util.Scanner;

/**
 * 《二叉排序树》
 *      二叉排序树（Binary Sort Tree），又称二叉查找树（Binary Search Tree），也称二叉搜索树。
 *  二叉排序树或者是一棵空树，或者是具有下列性质的二叉树：
 *  （1）若左子树不空，则左子树上所有结点的值均小于或等于它的根结点的值；
 *  （2）若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；
 *  （3）左、右子树也分别为二叉排序树；
 *
 *                61
 *               /  \
 *              55  87
 *             /  \
 *            42  58
 */
public class BinarySortTree {

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
         * 中序遍历
         */
        public void middleOrder() {
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

        /**
         * 插入结点
         */
        public void addNode(TreeNode node) {
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
        }

        /**
         * 查找结点
         */
        public TreeNode searchNode(TreeNode node) {
            // 查找结点的值等于当前结点
            if (node.value == this.value) {
                return this;
            } else if (node.value < this.value ) {
                //查找结点的值小于当前结点，继续从当前结点的左子结点查找
                if (this.left != null) {
                    return this.left.searchNode(node);
                }
            } else {
                //查找结点的值小于当前结点，继续从当前结点的左子结点查找
                if (this.right != null) {
                    return this.right.searchNode(node);
                }
            }
            return null;
        }

        /**
         * 查找父结点
         */
        public TreeNode searchParentNode(TreeNode node) {
            // 如果当前结点就是要查找结点的父结点，直接返回
            if ((this.left != null && this.left.value == node.value)
                    || (this.right != null && this.right.value == node.value)) {
                return this;
            // 如果查找结点小于当前结点的左结点，则往左子结点递归查找
            } else if (this.left != null && node.value < this.left.value) {
                return this.left.searchParentNode(node);
            // 如果查找结点大于当前结点的右结点，则往右子结点递归查找
            } else if (this.right != null && node.value > this.right.value){
                return this.right.searchParentNode(node);
            }
            return null;
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

    /**
     * 查找结点
     */
    public boolean search(int value) {
        TreeNode treeNode = searchNode(value);
        return treeNode != null ? true : false;
    }

    /**
     * 查找结点
     */
    private TreeNode searchNode(int value) {
        TreeNode node = new TreeNode(value);
        // 根结点为空时，直接返回
        if (rootNode == null) {
            return null;
        }
        return rootNode.searchNode(node);
    }

    /**
     * 查找父结点
     */
    private TreeNode searchParentNode(int value) {
        TreeNode node = new TreeNode(value);
        // 根结点为空或者要查找的结点就是根结点时，直接返回
        if (rootNode == null || rootNode.value == value) {
            return null;
        }
        return rootNode.searchParentNode(node);
    }

    /**
     * 删除指定结点下最小结点的值
     * 	1. 返回的是以node为根节点的二叉排序树的最小节点的值
     * 	2. 删除以node为根节点的二叉排序树的最小节点
     */
    private int delTreeMin(TreeNode node) {
        TreeNode target = node;
        // 循环的查找左节点，就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        // 这时target就指向了最小节点
        // 删除最小节点
        delete(target.value);
        return target.value;
    }

    /**
     * 删除结点
     */
    public void delete(int value) {
        // 根结点为空时，直接返回
        if (rootNode == null) {
            return;
        }
        // 1、需要先去找到要删除的节点targetNode，没有找到直接返回
        TreeNode targetNode = searchNode(value);
        if (targetNode == null) {
            return;
        }
        // 2、如果我们发现当前这颗二叉排序树删除的点就是根结点，且只有一个节点
        if (rootNode.left == null && rootNode.right == null) {
            rootNode = null;
            return;
        }
        // 3、去找到targetNode的父节点
        TreeNode parentNode = searchParentNode(value);
        // (1) 如果要删除的节点是叶子节点
        if (targetNode.left == null && targetNode.right == null) {
            // 判断targetNode是父节点的左子节点还是右子节点
            if (parentNode != null && parentNode.left != null && parentNode.left.value == value) {
                parentNode.left = null;
            } else if (parentNode != null && parentNode.right != null && parentNode.right.value == value) {
                parentNode.right = null;
            }
        // (2) 删除有两棵子树的节点
        } else if (targetNode.left != null && targetNode.right != null) {
            int minVal = delTreeMin(targetNode.right);
            targetNode.value = minVal;
        // (3) 删除只有一棵子树的节点
        } else {
            // 如果要删除的节点有左子节点
            if (targetNode.left != null) {
                if (parentNode != null) {
                    // 判断targetNode是父节点的左子节点还是右子节点
                    if (parentNode.left.value == value) {
                        parentNode.left = targetNode.left;
                    } else {
                        parentNode.right = targetNode.left;
                    }
                } else {
                    // 表示删除的是根结点
                    rootNode = targetNode.left;
                }
            // 如果要删除的节点有右子节点
            } else {
                if (parentNode != null) {
                    // 判断targetNode是父节点的左子节点还是右子节点
                    if (parentNode.left.value == value) {
                        parentNode.left = targetNode.right;
                    } else {
                        parentNode.right = targetNode.right;
                    }
                } else {
                    // 表示删除的是根结点
                    rootNode = targetNode.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 61 87 55 42 58
        BinarySortTree binarySortTree = new BinarySortTree();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.print("【二叉排序树】插入(1)、查找(2)、删除(3)、遍历(4)、退出(0)：");
            Integer key = scanner.nextInt();
            switch (key) {
                case 1:
                    System.out.print("请输入插入值：");
                    int value = scanner.nextInt();
                    binarySortTree.add(value);
                    break;
                case 2:
                    System.out.print("请输入查找值：");
                    int value2 = scanner.nextInt();
                    System.out.println("查找结果：" + binarySortTree.search(value2));
                    break;
                case 3:
                    System.out.print("请输入删除值：");
                    int value3 = scanner.nextInt();
                    binarySortTree.delete(value3);
                    break;
                case 4:
                    binarySortTree.middleOrderPrint();
                    System.out.println();
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
