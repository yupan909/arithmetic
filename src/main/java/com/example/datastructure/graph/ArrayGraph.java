package com.example.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 《图》
 *   邻接矩阵（数组）：用两个数组来表示图。一个一维数组存储图中顶点信息，一个二维数组（称为邻接矩阵）存储图中的边或弧的信息。
 *
 *                          顶点数组：   A B C D E
 *       A                              0 1 2 3 4
 *     /   \
 *    B     C     --->      边数组：    A  B  C  D  E
 *   / \                            A  0  1  1  0  0
 * D -- E                           B  1  0  0  1  1
 *                                  C  1  0  0  0  0
 *                                  D  0  1  0  0  1
 *                                  E  0  1  0  1  0
 * @author yupan
 * @date 12/22/20 5:21 PM
 */
public class ArrayGraph<V, E> implements Graph<V, E> {

    /**
     * 存放顶点的一维数组
     */
    private Object[] vertexArray;

    /**
     * 存放边的二维数组
     */
    private Object[][] edgeArray;

    /**
     * 顶点的实际数量
     */
    private int vertexSize;

    /**
     * 顶点的最大数量
     */
    private int vertexMaxSize;

    public ArrayGraph(int vertexMaxSize) {
        this.vertexSize = 0;
        this.vertexMaxSize = vertexMaxSize;
        this.vertexArray = new Object[vertexMaxSize];
        this.edgeArray = new Object[vertexMaxSize][vertexMaxSize];
    }

    /**
     * 根据索引获取顶点
     */
    public Object getVertexOfIndex(int index) {
        return vertexArray[index];
    }

    /**
     * 获取顶点的索引
     */
    @Override
    public int indexOfVertex(V v) {
        for (int i = 0; i < vertexSize; i++) {
            if (vertexArray[i] != null && Objects.equals(vertexArray[i], v)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 新增顶点
     */
    @Override
    public void addVertex(V v) {
        if (vertexSize >= vertexMaxSize) {
            System.out.println("新增失败，图顶点已满！");
            return;
        }
        vertexArray[vertexSize++] = v;
    }

    /**
     * 新增边
     */
    @Override
    public void addEdge(V v1, V v2, E e) {
        int index1 = indexOfVertex(v1);
        if (index1 == -1) {
            System.out.println("新增失败，顶点不存在" + v1.toString());
            return;
        }
        int index2 = indexOfVertex(v2);
        if (index2 == -1) {
            System.out.println("新增失败，顶点不存在" + v2.toString());
            return;
        }
        edgeArray[index1][index2] = e;
        edgeArray[index2][index1] = e;
    }

    /**
     * 获取边
     * @return
     */
    @Override
    public E getEdge(V v1, V v2) {
        int index1 = indexOfVertex(v1);
        if (index1 == -1) {
            System.out.println("获取失败，顶点不存在" + v1.toString());
            return null;
        }
        int index2 = indexOfVertex(v2);
        if (index2 == -1) {
            System.out.println("获取失败，顶点不存在" + v2.toString());
            return null;
        }
        return (E) edgeArray[index1][index2];
    }

    /**
     * 获取顶点数量
     */
    @Override
    public int size() {
        return vertexSize;
    }

    /**
     * 存放边的二维数组
     */
    public Object[][] getEdgeArray() {
        return this.edgeArray;
    }

    /**
     * 获取指定顶点的第一个邻接顶点
     * @return
     */
    private int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexArray.length; i++) {
            if (edgeArray[index][i] != null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据指定顶点的前一个邻接顶点获取下一个邻接顶点
     * @return
     */
    private int getNextNeighbor(int index, int w) {
        for (int i = w + 1; i < vertexArray.length; i++) {
            if (edgeArray[index][i] != null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先搜索遍历（DFS）
     */
    public void dfs() {
        if (vertexSize == 0) {
            System.out.println("图为空");
            return;
        }
        boolean[] isVisted = new boolean[vertexSize];
        dfs(0, isVisted);
    }

    /**
     * 深度优先搜索遍历算法步骤
     * 1）访问初始节点v，并标记节点v以访问
     * 2）查找节点v的第一个邻接节点w
     * 3）若w存在，执行4，若w不存在，回到第一步，从v的下一个节点继续
     * 4）若w未被访问，对w进行深度优先遍历递归
     * 5）若w被访问，以下一个邻接节点作为初始节点进行递归
     */
    private void dfs(int v, boolean[] isVisted) {
        System.out.printf("%s\t", vertexArray[v]);
        // 设置为访问过
        isVisted[v] = true;
        // 获取指定顶点的第一个邻接顶点
        int w = getFirstNeighbor(v);
        while (w != -1) {
            // 当前顶点没有访问过
            if (!isVisted[w]) {
                dfs(w, isVisted);
            }
            // 访问下一个邻接顶点
            w = getNextNeighbor(v, w);
        }
    }

    /**
     * 广度优先搜索遍历（BFS）
     */
    public void bfs() {
        if (vertexSize == 0) {
            System.out.println("图为空");
            return;
        }
        boolean[] isVisted = new boolean[vertexSize];
        bfs(0, isVisted);
    }

    /**
     * 广度优先搜索遍历算法步骤
     * 1）访问初始节点v并标记v为已访问
     * 2）节点v入队列
     * 3）当队列非空时，继续执行，否则算法结束
     * 4）出队列，取得队头节点u
     * 5）查找节点u的第一个邻接节点w
     * 6）若节点u的邻接节点w不存在，进行步骤3，否则循环执行以下三个步骤
     *  6.1若w未被访问，则访问节点w并记为已访问
     *  6.2节点w入队列
     *  6.3查找节点u的继ww邻接节点的下一个邻接节点w，转到步骤6
     */
    private void bfs(int v, boolean[] isVisted) {
        // 输出初始结点v
        System.out.printf("%s\t", vertexArray[v]);
        // 设置为访问过
        isVisted[v] = true;
        // 将访问的结点v加入队列中
        List<Integer> list = new ArrayList();
        list.add(v);
        // 队列不为空时循环执行
        while (!list.isEmpty()) {
            // 获取队列头结点
            int u = list.remove(0);
            // 获取第一个邻接顶点
            int w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisted[w]) {
                    // 输出初始结点w
                    System.out.printf("%s\t", vertexArray[w]);
                    // 设置为访问过
                    isVisted[w] = true;
                    // 加入队列
                    list.add(w);
                }
                // 访问下一个邻接顶点
                w = getNextNeighbor(u, w);
            }
        }
    }

    /**
     * 打印数组
     */
    public void print() {
        for (int i = 0; i < vertexSize; i++) {
            for (int j=0; j < vertexSize; j++) {
                System.out.printf("%s\t", edgeArray[i][j] == null ? 0 : edgeArray[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayGraph<String, Integer> arrayGraph = new ArrayGraph<>(5);
        // 添加顶点
        arrayGraph.addVertex("A");
        arrayGraph.addVertex("B");
        arrayGraph.addVertex("C");
        arrayGraph.addVertex("D");
        arrayGraph.addVertex("E");
        // 添加边
        arrayGraph.addEdge("A", "B", 1);
        arrayGraph.addEdge("A", "C", 1);
        arrayGraph.addEdge("B", "D", 1);
        arrayGraph.addEdge("B", "E", 1);
        arrayGraph.addEdge("D", "E", 1);
        System.out.println("打印邻接矩阵:");
        arrayGraph.print();

        System.out.println("获取顶点数量:" + arrayGraph.size());
        System.out.println("获取边:" + arrayGraph.getEdge("A", "B"));
        System.out.println("深度优先搜索遍历（DFS）：");
        arrayGraph.dfs();
        System.out.println();
        System.out.println("广度优先搜索遍历（BFS）：");
        arrayGraph.bfs();
    }
}
