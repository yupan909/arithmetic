package com.example.arithmetic.common;


import com.example.datastructure.graph.ArrayGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 《Prim算法》
 *     普里姆算法（Prim算法），图论中的一种算法，可在加权连通图里搜索最小生成树(Minimum Cost Spanning Tree)，简称MST。意即由此算法搜索到的边子集所构成的树中，
 *  不但包括了连通图里的所有顶点，且其所有边的权值之和亦为最小。
 *
 *  普里姆算法和Kruskal算法的区别：两者都是贪心策略追求最优解,但是普里姆算法讲究全局优先,Kruskal算法讲究的是局部优先.
 *
 *  最佳应用-修路问题
 *     胜利乡有7个村庄(A, B, C, D, E, F, G)，现在需要修路把7个村庄连通，各个村庄的距离用边线表示(权)，比如A–B距离5公里，问：如何修路保证各个村庄都能连通，并且总的修建公路总里程最短?
 *
 *                     5
 *                【A】--【B】                          【A】  【B】
 *              7 /  \   / \  9                      7 /  \   /
 *               /  2 \ / 3 \                         /  2 \ / 3
 *            【C】   【G】 【D】        ----->     【C】   【G】 【D】
 *               \   4/ \6  /                             4/     /
 *              8 \  /   \ / 4                            /     / 4
 *                【E】--【F】                          【E】--【F】
 *                     5                                    5
 *  算法分析：
 *   （1）<A>顶点开始处理，选取权值最小的边A-G[2]  ==> <A,G>
 *       A-C[7]、A-G[2]、A-B[5]
 *   （2）<A,G>开始,将A和G顶点和他们相邻的还没有访问的顶点进行处理，选择G-B[3]  ==> <A,G,B>
 *       A-C[7]、A-B[5]、G-B[3]、G-E[4]、G-F[6]
 *   （3）<A,G,B>开始，将A,G,B 顶点和他们相邻的还没有访问的顶点进行处理，选择G-E[4] ==> <A,G,B,E>
 *       A-C[7]、G-E[4]、G-F[6]、B-D[9]
 *   （4）<A,G,B,E> 选择E-F[5]  ==> <A,G,B,E,F>
 *   （5）<A,G,B,E,F> 选择F-D[4]  ==> <A,G,B,E,F,D>
 *   （6）<A,G,B,E,F,D> 选择A-C[7]  ==> <A,G,B,E,F,D,C>
 *
 * @author yupan
 * @date 1/8/21 4:08 PM
 */
public class Prim {

    /**
     * Prim算法求最小生成树
     * @param graph 村庄的图
     * @param vertex 图的开始顶点
     * @return
     */
    public static Integer minTree(ArrayGraph graph, String vertex) {
        Integer sumWeight = 0;
        // 存放已选择的结点对应的索引
        List<Integer> vertexList = new ArrayList<>();
        // 放入开始结点的索引
        vertexList.add(graph.indexOfVertex(vertex));
        // 获取图中边的二维数组
        Object[][] array = graph.getEdgeArray();
        // 每一次遍历都会找到一个合适的结点
        for (int i = 1; i < graph.size(); i++) {
            Integer minVal = null;
            Integer tempIndex = null;
            // 从已选的结点中选取权值最小的边
            for (Integer index : vertexList) {
                for (int j = 0; j < array.length; j++) {
                    Integer weight = (Integer) array[index][j];
                    if (weight != null && !vertexList.contains(j)) {
                        if (minVal == null || weight < minVal) {
                            minVal = weight;
                            tempIndex = j;
                        }
                    }
                }
            }
            // 记录权值最小的结点
            if (tempIndex != null) {
                sumWeight += minVal;
                vertexList.add(tempIndex);
                System.out.println("加入结点："+  graph.getVertexOfIndex(tempIndex));
            }
        }
        return sumWeight;
    }

    public static void main(String[] args) {
        ArrayGraph graph = new ArrayGraph(7);
        // 添加顶点
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        // 添加边
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 7);
        graph.addEdge("A", "G", 2);
        graph.addEdge("B", "G", 3);
        graph.addEdge("B", "D", 9);
        graph.addEdge("C", "E", 8);
        graph.addEdge("E", "F", 5);
        graph.addEdge("E", "G", 4);
        graph.addEdge("F", "G", 6);
        graph.addEdge("D", "F", 4);
        System.out.println("打印村庄的图:");
        graph.print();

        System.out.println("Prim算法求最小生成树：" + Prim.minTree(graph, "A"));
    }

}
