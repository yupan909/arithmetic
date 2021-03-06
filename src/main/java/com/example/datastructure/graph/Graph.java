package com.example.datastructure.graph;

/**
 * 图（Graph）是由顶点的有穷非空集合和顶点之间边的集合组成，通常表示为：G(V,E)，其中，G表示一个图，V是图G中顶点的集合，E是图G中边的集合。
 *
 *  图的存储结构：
 *  1、邻接矩阵（数组）
 *  2、邻接表（链表）
 *
 *  图的遍历：
 *  1、深度优先搜索遍历（DFS）
 *  2、广度优先搜索遍历（BFS）
 *
 *  深度优先搜索思想：
 *      假设初始状态是图中所有顶点均未被访问，则从某个顶点v出发，首先访问该顶点，然后依次从它的各个未被访问的邻接点出发深度优先搜索遍历图，
 *   直至图中所有和v有路径相通的顶点都被访问到。若此时尚有其他顶点未被访问到，则另选一个未被访问的顶点作起始点，重复上述过程，
 *   直至图中所有顶点都被访问到为止。
 *
 *  广度优先搜索思想：
 *      从图中某顶点v出发，在访问了v之后依次访问v的各个未曾访问过的邻接点，然后分别从这些邻接点出发依次访问它们的邻接点，
 *   并使得“先被访问的顶点的邻接点先于后被访问的顶点的邻接点被访问，直至图中所有已被访问的顶点的邻接点都被访问到。如果此时图中尚有顶点未被访问，
 *   则需要另选一个未曾被访问过的顶点作为新的起始点，重复上述过程，直至图中所有顶点都被访问到为止。
 *
 * @author yupan
 * @date 12/22/20 5:05 PM
 */
public interface Graph<V, E> {

    /**
     * 新增顶点
     */
    void addVertex(V v);

    /**
     * 新增边
     * @param v1 顶点1
     * @param v2 顶点2
     * @param e 权值
     */
    void addEdge(V v1, V v2, E e);

    /**
     * 获取边
     * @param v1 顶点1
     * @param v2 顶点2
     */
    E getEdge(V v1, V v2);

    /**
     * 获取顶点数量
     */
    int size();

    /**
     * 获取边数量
     */
    int edgeSize();

    /**
     * 获取顶点的索引
     */
    int indexOfVertex(V v);
}
