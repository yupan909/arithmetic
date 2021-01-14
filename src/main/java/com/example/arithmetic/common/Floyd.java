package com.example.arithmetic.common;


import com.example.datastructure.graph.ArrayGraph;

/**
 * 《Floyd算法》
 *     弗洛伊德(Floyd)算法是典型最短路径算法，用于计算一个节点到其他节点的最短路径。
 *     Floyd算法又称为插点法，是一种利用动态规划的思想寻找给定的加权图中多源点之间最短路径的算法，与Dijkstra算法类似。该算法是一种在具有正或负边缘权重（但没有负环）的加权图中找到最短路径的算法
 *
 *   基本思想
 *      通过Floyd计算图G=(V,E)中各个顶点的最短路径时，需要引入一个矩阵S，矩阵S中的元素a[i][j]表示顶点i(第i个顶点)到顶点j(第j个顶点)的距离。
 *      假设图G中顶点个数为N，则需要对矩阵S进行N次更新。初始时，矩阵S中顶点a[i][j]的距离为顶点i到顶点j的权值；如果i和j不相邻，则a[i][j]=∞。
 *   接下来开始，对矩阵S进行N次更新。第1次更新时，如果"a[i][j]的距离" > "a[i][0]+a[0][j]"(a[i][0]+a[0][j]表示"i与j之间经过第1个顶点的距离")，则更新a[i][j]为"a[i][0]+a[0][j]"。
 *   同理，第k次更新时，如果"a[i][j]的距离" > "a[i][k]+a[k][j]"，则更新a[i][j]为"a[i][k]+a[k][j]"。更新N次之后，操作完成！
 *
 *  弗洛伊德(Floyd)算法和迪杰斯特拉(Dijkstra)算法的区别：
 *    1、Floyd算法本质是贪心算法；Dijkstra算法本质是动态规划算法。
 *    2、Floyd算法偏重于多源最短路径的求解，即能够求出任意两个节点的最短路径；Dijkstra肃算法是单源最短路径的求解，能够求一个节点到其余所有节点的最短路径。
 *    3、Floyd算法支持正权重或负权重；Dijkstra算法只支持正权重。
 *
 *  最佳应用
 *     胜利乡有7个村庄(A, B, C, D, E, F, G)，请问从各个村庄分别到达其他村庄的最短路径
 *
 *                     5
 *                【A】--【B】
 *              7 /  \   / \  9
 *               /  2 \ / 3 \
 *            【C】   【G】 【D】
 *               \   4/ \6  /
 *              8 \  /   \ / 4
 *                【E】--【F】
 *                     5
 *
 * @author yupan
 * @date 1/8/21 4:08 PM
 */
public class Floyd {

    /**
     * floyd最短路径
     * 即，统计图中各个顶点间的最短路径。
     */
    public static void minPath(ArrayGraph graph) {
        // 路径数组  path[i][j]=k表示，"顶点i"到"顶点j"的最短路径会经过顶点k。
        Integer[][] path = new Integer[graph.size()][graph.size()];
        // 长度数组  dist[i][j]=sum表示，"顶点i"到"顶点j"的最短路径的长度是sum。
        Integer[][] dist = new Integer[graph.size()][graph.size()];

        // 初始化
        Object[][] array = graph.getEdgeArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                // "顶点i"到"顶点j"的路径长度为"i到j的权值"
                dist[i][j] =  (Integer) array[i][j];
                // "顶点i"到"顶点j"的最短路径是经过顶点j。
                path[i][j] = j;
            }
        }

        // 计算最短路径
        for (int k = 0; k < graph.size(); k++) {
            for (int i = 0; i < graph.size(); i++) {
                for (int j = 0; j < graph.size(); j++) {
                    // 如果经过下标为k顶点路径比原两点间路径更短，则更新dist[i][j]和path[i][j]
                    Integer tmp = (dist[i][k] == null || dist[k][j] == null) ? null : (dist[i][k] + dist[k][j]);
                    if (tmp != null) {
                        if (dist[i][j] == null || dist[i][j] > tmp) {
                            // "i到j最短路径"对应的值设，为更小的一个(即经过k)
                            dist[i][j] = tmp;
                            // "i到j最短路径"对应的路径，经过k
                            path[i][j] = path[i][k];
                        }
                    }
                }
            }
        }

        // 打印floyd最短路径的结果
        System.out.println("Floyd算法求最短路径:");
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                System.out.printf("%2d  ", dist[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        ArrayGraph<String, Integer> graph = new ArrayGraph(7);
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

        System.out.println();
        // floyd最短路径
        Floyd.minPath(graph);
    }

}
