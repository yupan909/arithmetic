package com.example.datastructure.graph;

import java.util.Objects;

/**
 * 《图》
 *   邻接矩阵（数组）：用两个数组来表示图。一个一维数组存储图中顶点信息，一个二维数组（称为邻接矩阵）存储图中的边或弧的信息。
 *
 *                          顶点数组：   A B C D
 *       A                              0 1 2 3
 *   3 /   \ 2
 *    B --- D     --->      边数组：    A  B  C  D
 *   1 \ 4                          A  0  3  0  2
 *      C                           B  3  0  1  4
 *                                  C  0  1  0  0
 *                                  D  2  4  0  0
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
     * 获取顶点的索引
     */
    private int indexOfVertex(V v) {
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
        // 添加边
        arrayGraph.addEdge("A", "B", 3);
        arrayGraph.addEdge("A", "D", 2);
        arrayGraph.addEdge("B", "C", 1);
        arrayGraph.addEdge("B", "D", 4);
        System.out.println("打印邻接矩阵:");
        arrayGraph.print();
        System.out.println("获取顶点数量:" + arrayGraph.size());
        System.out.println("获取边:" + arrayGraph.getEdge("A", "B"));
    }
}
