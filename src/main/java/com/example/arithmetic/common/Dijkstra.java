package com.example.arithmetic.common;


import com.example.datastructure.graph.ArrayGraph;

/**
 * 《Dijkstra算法》
 *     迪杰斯特拉(Dijkstra)算法是典型最短路径算法，用于计算一个节点到其他节点的最短路径。 它的主要特点是以起始点为中心向外层层扩展(广度优先搜索思想)，直到扩展到终点为止。
 *
 *   基本思想
 *      通过Dijkstra计算图G中的最短路径时，需要指定起点s(即从顶点s开始计算)。
 *      此外，引进两个集合S和U。S的作用是记录已求出最短路径的顶点(以及相应的最短路径长度)，而U则是记录还未求出最短路径的顶点(以及该顶点到起点s的距离)。
 *      初始时，S中只有起点s；U中是除s之外的顶点，并且U中顶点的路径是"起点s到该顶点的路径"。然后，从U中找出路径最短的顶点，并将其加入到S中；
 *   接着，更新U中的顶点和顶点对应的路径。 然后，再从U中找出路径最短的顶点，并将其加入到S中；接着，更新U中的顶点和顶点对应的路径。 ... 重复该操作，直到遍历完所有顶点。
 *
 *  最佳应用
 *     胜利乡有7个村庄(A, B, C, D, E, F, G)，请问从A村庄分别到达其他村庄的最短路径
 *
 *                     5                                    5
 *                【A】--【B】                          【A】--【B】
 *              7 /  \   / \  9                      7 /  \
 *               /  2 \ / 3 \                         /  2 \
 *            【C】   【G】 【D】        ----->     【C】   【G】 【D】
 *               \   4/ \6  /                             4/ \6  /
 *              8 \  /   \ / 4                            /   \ / 4
 *                【E】--【F】                          【E】  【F】
 *                     5
 *  算法分析：
 *   初始状态：S是已计算出最短路径的顶点集合，U是未计算除最短路径的顶点的集合！
 *   (1)将顶点A加入到S中
 *      S = {A(null)}
 *      U = {B(5), C(7), D(null), E(null), F(null), G(2)}     注:C(3)表示C到起点A的距离是7。
 *
 *   (2)将顶点G加入到S中
 *     上一步操作之后，U中顶点G到起点A的距离最短；因此，将G加入到S中，同时更新U中顶点的距离。
 *     以顶点F为例，之前F到A的距离为null, 表示不通；但是将G加入到S之后，F到A的距离为8=(F,G)+(G,A)。
 *      S = {A(null), G(2)}
 *      U = {B(5), C(7), D(null), E(6), F(8)}
 *
 *   (3)将顶点B加入到S中。
 *     上一步操作之后，U中顶点B到起点A的距离最短；因此，将B加入到S中，同时更新U中顶点的距离。
 *     以顶点D为例，之前D到A的距离为null, 但是将B加入到S之后，D到A的距离为14=(D,B)+(B,A)。
 *      S = {A(null), G(2), B(5)}
 *      U = {C(7), D(14), E(6), F(8)}
 *
 *   (4)将顶点E加入到S中。
 *      S = {A(null), G(2), B(5), E(6)}
 *      U = {C(7), D(14), F(8)}
 *
 *   (5)将顶点C加入到S中。
 *      S = {A(null), G(2), B(5), E(6), C(7)}
 *      U = {D(14), F(8)}
 *
 *   (6)将顶点F加入到S中。
 *     上一步操作之后，U中顶点F到起点A的距离最短；因此，将F加入到S中，同时更新U中顶点的距离。
 *     以顶点D为例，之前D到A的距离为14, 但是将F加入到S之后，D到A的距离为12=(D,F)+(F,G)+(G,A)。
 *      S = {A(null), G(2), B(5), E(6), C(7), F(8)}
 *      U = {D(12)}
 *
 *   (7)将顶点D加入到S中。
 *      S = {A(null), G(2), B(5), E(6), C(7), F(8), D(12)}
 *      U = {}
 *
 *   此时，起点A到各个顶点的最短距离就计算出来了：B(5) C(7) D(12) E(6) F(8) G(2)
 *
 * @author yupan
 * @date 1/8/21 4:08 PM
 */
public class Dijkstra {

    /**
     * Dijkstra最短路径。
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     */
    public Integer minPath(ArrayGraph graph, String start) {
        Integer sumWeight = 0;

        // 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
        int vs = graph.indexOfVertex(start);
        // 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
        Integer[] dist = new Integer[graph.size()];
        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
        boolean[] flag = new boolean[graph.size()];

        Object[][] array = graph.getEdgeArray();
        // 初始化
        for (int i = 0; i < graph.size(); i++) {
            // 顶点i的最短路径还没获取到。
            flag[i] = false;
            // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
            dist[i] = (Integer)array[vs][i];
        }

        // 对"顶点vs"自身进行初始化
        flag[vs] = true;

        // 遍历graph.size()-1次；每次找出一个顶点的最短路径。
        int k = 0;
        for (int i = 1; i < graph.size(); i++) {
            // (1)寻找当前最小的路径；即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
            Integer min = null;
            for (int j = 0; j <  graph.size(); j++) {
                if (!flag[j] && dist[j] != null) {
                    if (min == null || dist[j] < min) {
                        min = dist[j];
                        k = j;
                    }
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;

            // (2)修正当前最短路径和前驱顶点；即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < graph.size(); j++) {
                if (!flag[j] && array[k][j] != null) {
                    // 1、先获取当前顶点经过顶点k连接顶点vs的路径
                    Integer tmp = min != null ? (min + (int)array[k][j]) : (int)array[k][j];
                    // 2、然后跟当前顶点直接连接顶点vs的路径进行比较，取较小路径
                    if (dist[j] == null || tmp < dist[j]){
                        dist[j] = tmp;
                    }
                }
            }
        }

        // 打印dijkstra最短路径的结果
        for (int i = 0; i < dist.length; i++) {
            // 顶点跳过
            if (dist[i] == null) {
                continue;
            }
            System.out.println("顶点" + start + "到结点" + graph.getVertexOfIndex(i) + "的最短路径：" + dist[i]);
            sumWeight += dist[i];
        }
        return sumWeight;
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

        Dijkstra dijkstra = new Dijkstra();
        System.out.println("Dijkstra算法求最短路径：" + dijkstra.minPath(graph, "A"));
    }

}
