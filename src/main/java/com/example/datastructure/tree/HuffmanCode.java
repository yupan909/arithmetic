package com.example.datastructure.tree;

import java.util.*;

/**
 * 《哈夫曼编码》
 *      哈夫曼编码(Huffman Coding)，又称霍夫曼编码，是一种编码方式，哈夫曼编码是可变字长编码(VLC)的一种。Huffman于1952年提出一种编码方法，
 *  该方法完全依据字符出现概率来构造异字头的平均长度最短的码字，有时称之为最佳编码，一般就叫做Huffman编码（有时也称为霍夫曼编码）。
 *
 *      哈夫曼编码具有广泛的应用，利用哈夫曼树构造的用于通信的二进制编码称为哈夫曼编码。
 *  例如： 有一段电文"CAST&TAT&A&SAT&AA&"。统计电文中字母的频度 f('C')=1,f('S')=2,f('T')=4,f('&')=5,f('A')=6；
 *  用频度{ 1 ， 2 ， 3 ， 3 ， 4 } 为权值生成哈夫曼树，并在每个叶子上注明对应的字符。树中从根到每个叶子都有一条路径，
 *  对路径上的各分枝约定指向左子树根的分枝表示"0"码，指向右子树的分枝表示"1"码，取每条路径上的"0"或"1"的序列作为和各个叶子对应的字符的编码，
 *  这就是哈夫曼编码。对应下图的哈夫曼树，上述字符编码为：
 *
 *                      C(67)   S(83)   T(84)   &(38)   A(65)
 *                       000     001      01     10      11
 *
 *                                 ⑱
 *                              0/    \1
 *                             ⑦      ⑪
 *                           0/  \1  0/  \1
 *                          ③   ④T ⑤& ⑥A
 *                        0/ \1
 *                       ①C　②S
 *
 */
public class HuffmanCode {

    /**
     * 根结点
     */
    private TreeNode rootNode;

    /**
     * 哈夫曼编码表存放集合
     */
    private Map<Byte, String> huffmanCodeMap = new HashMap<>();

    /**
     * 结点类
     */
    private class TreeNode implements Comparable<TreeNode>{
        // 数据
        private Byte data;
        // 权重
        private Integer weight;
        // 左结点
        private TreeNode left;
        // 右结点
        private TreeNode right;

        public TreeNode(Byte data, Integer weight, TreeNode left, TreeNode right) {
            this.data = data;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" + "data=" + data + ", weight=" + weight + '}';
        }

        @Override
        public int compareTo(TreeNode o) {
            return this.weight - o.weight;
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
        beforeOrderPrint(rootNode);
    }

    private void beforeOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        // 1、输出结点
        System.out.println(node);
        // 2、前序遍历左子树
        beforeOrderPrint(node.left);
        // 3、前序遍历右子树
        beforeOrderPrint(node.right);
    }

    /**
     * 生成哈夫曼编码表
     */
    private void createHuffmanCode(){
        if (rootNode == null) {
            System.out.println("根结点为空！");
            return;
        }
        getNodeCode(rootNode, null, null);
    }

    /**
     * 获取结点对应的编码
     * @param node 结点
     * @param code 编码字符：0 或 1
     * @param stringBuilder 编码
     */
    private void getNodeCode(TreeNode node, Byte code, StringBuilder stringBuilder) {
        StringBuilder sb = new StringBuilder();
        if (stringBuilder != null) {
            sb.append(stringBuilder);
        }
        if (code != null) {
            sb.append(code);
        }
        // 如果当前结点是非子结点时，继续往下
        if (node.data == null) {
            if (node.left != null) {
                getNodeCode(node.left, (byte)0, sb);
            }
            if (node.right != null) {
                getNodeCode(node.right, (byte)1, sb);
            }
        } else {
            huffmanCodeMap.put(node.data, sb.toString());
        }
    }

    /**
     * 构建哈夫曼树
     */
    private void buildHuffmanTree(String str) {
        // 统计编码的频度
        Map<Byte, Integer> collectMap = getCollectMap(str);
        if (collectMap == null || collectMap.isEmpty()) {
            return;
        }

        // 创建存放结点的集合
        List<TreeNode> nodeList = new ArrayList<>();
        collectMap.forEach((k, v) -> {
            nodeList.add(new TreeNode(k, v, null, null));
        });

        while (nodeList.size() > 1) {
            // 1、将集合按从小到大排序
            Collections.sort(nodeList);
            // 2、取出根结点权值最小的两颗二叉树
            TreeNode leftNode = nodeList.get(0);
            TreeNode rightNode = nodeList.get(1);
            // 3、组成一棵新的二叉树，该二叉树的根结点的权值是这两颗二叉树根结点权值之和
            TreeNode parentNode = new TreeNode(null, (leftNode.weight + rightNode.weight), leftNode, rightNode);
            // 4、添加新的二叉树根结点
            nodeList.add(parentNode);
            // 5、移除刚刚处理过的两个二叉树根结点
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
        }
        rootNode = nodeList.get(0);
    }

    /**
     * 统计编码的频度
     * @return
     */
    private Map<Byte, Integer> getCollectMap(String str) {
        if (str == null) {
            return Collections.EMPTY_MAP;
        }
        // 转成二进制
        byte[] bytes = str.getBytes();
        Map<Byte, Integer> collectMap = new HashMap<>();
        for (Byte b : bytes) {
            Integer count = collectMap.get(b);
            if (count == null) {
                collectMap.put(b, 1);
            } else {
                collectMap.put(b, count + 1);
            }
        }
        return collectMap;
    }

    /**
     * 编码
     * @return
     */
    public String encode(String str) {
        if (str == null) {
            return null;
        }
        // 1、构建哈夫曼树
        buildHuffmanTree(str);
        // 2、生成哈夫曼编码表
        createHuffmanCode();
        // 3、进行编码
        StringBuilder sb = new StringBuilder();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            sb.append(huffmanCodeMap.get(b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "CAST&TAT&A&SAT&AA&";
//        System.out.println(Arrays.toString("囗".getBytes()));
//        System.out.println(str.getBytes().length);

        HuffmanCode binaryCode = new HuffmanCode();
//        binaryCode.buildHuffmanTree(str);
//        System.out.println("前序遍历哈夫曼树：");
//        binaryCode.beforeOrderPrint();
//
//        binaryCode.createHuffmanCode();
//        Map<Byte, String> huffmanCodeMap = binaryCode.huffmanCodeMap;
//        huffmanCodeMap.forEach((k, v) -> {
//            System.out.println("k:" + k + "v:" + v);
//        });
        System.out.println("编码结果：" + binaryCode.encode(str));


    }

}
