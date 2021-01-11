package com.example.arithmetic.common;


import com.example.datastructure.graph.ArrayGraph;
import java.util.Arrays;

/**
 * 《Kruskal算法》
 *     克鲁斯卡尔算法（Kruskal算法），是用来求加权连通图的最小生成树的算法
 *
 *   基本思想：按照权值从小到大的顺序选择n-1条边，并保证这n-1条边不构成回路。
 *   具体做法：首先构造一个只含n个顶点的森林，然后依权值从小到大从连通网中选择边加入到森林中，并使森林中不产生回路，直至森林变成一棵树为止。
 *
 *  普里姆算法和鲁斯卡尔算法的区别：
 *   (1)普里姆(Prim)算法思想：
 *         以某一顶点为起点，一点一点的去找各顶点上最小权值的边来构建最小生成树。图的存储结构是邻接矩阵，此方法需要一个顶点集合T，开始的时候为空集，
 *      慢慢的会将连通的顶点陆续的加入到集合中，全部顶点都加入集合以后，就得到我们所需要的最小生成树啦！
 *   (2)克鲁斯卡尔(Kruskal)算法思想：
 *         直接以边为目标，按照权值从小到大的顺序选择n-1条边来构建最小生成树，并且不能形成回路。图的存储结构采用的是边集数组，且权值相等的边在数组中的排列次序是任意的，
 *      如果图中的边数较多则此算法会很浪费时间！
 *  两者都是贪心策略追求最优解，但是Prim算法讲究全局优先，Kruskal算法讲究的是局部优先。
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
 *   （1)边<A, G>权值2最小，加入到最小生成树结果中；
 *   （2)上一步后，边<B, G>权值3最小，加入到最小生成树结果中；
 *   （3)上一步后，边<E, G>权值4最小，加入到最小生成树结果中；
 *   （4)上一步后，边<D, F>权值4最小，加入到最小生成树结果中；
 *   （5)上一步后，边<A, B>权值5最小，但会和已有的边构成回路, 则跳过；
 *   （6)上一步后，边<E, F>权值5最小，加入到最小生成树结果中；
 *   （7)上一步后，边<F, G>权值6最小，但会和已有的边构成回路, 则跳过；
 *   （8)上一步后，边<A, C>权值7最小，加入到最小生成树结果中;
 *   （9)上一步后，边<C, E>权值8最小，但会和已有的边构成回路, 则跳过；
 *   （10)上一步后，边<B, D>权值9最小，但会和已有的边构成回路, 则跳过；
 *
 * @author yupan
 * @date 1/8/21 4:08 PM
 */
public class Kruskal {

    /**
     * 边的结构体
     */
    class Edge implements Comparable<Edge>{
        // 边的开始结点
        private String start;
        // 边的结束结点
        private String end;
        // 边的权值
        private Integer weight;

        public Edge(String start, String end, Integer weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge<" + start + ", " + end + ">[" + weight + "]";
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

    }

    /**
     * Kruskal算法求最小生成树
     * @param graph 村庄的图
     * @return
     */
    public Integer minTree(ArrayGraph graph) {
        Integer sumWeight = 0;
        // 获取所有的边
        Edge[] edges = getEdge(graph);
        // 按权值从小到大排序
        Arrays.sort(edges);
        // 用于保存"已有最小生成树"中每个顶点对应的终点
        int[] ends = new int[edges.length];
        // 按顺序依次遍历所有的边
        for (int i = 0; i < edges.length; i++) {
            int p1 = graph.indexOfVertex(edges[i].start);
            int p2 = graph.indexOfVertex(edges[i].end);
            int m = getEnds(ends, p1);
            int n = getEnds(ends, p2);
            // 判断是否形成环路（判断该边的两个顶点的终点是否重合，重合的话则会构成回路）
            if (m != n) {
                ends[m] = n;
                sumWeight += edges[i].weight;
                System.out.println("加入边："+  edges[i]);
            }
        }
        return sumWeight;
    }

    /**
     * 获取下标为i的顶点对应的终点
     * @return
     */
    private int getEnds(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    /**
     * 获取图的边集合
     * @return
     */
    private Edge[] getEdge(ArrayGraph graph) {
        int edgeNum = 0;
        Edge[] edges = new Edge[graph.edgeSize()];
        Object[][] array = graph.getEdgeArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array[i].length; j++) {
                if (array[i][j] != null) {
                    String start = (String)graph.getVertexOfIndex(i);
                    String end = (String)graph.getVertexOfIndex(j);
                    edges[edgeNum++] = new Edge(start, end, (Integer)array[i][j]);
                }
            }
        }
        return edges;
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

        Kruskal kruskal = new Kruskal();
        System.out.println("Kruskal算法求最小生成树：" + kruskal.minTree(graph));
    }

}
