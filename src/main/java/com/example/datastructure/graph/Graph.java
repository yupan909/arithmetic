package com.example.datastructure.graph;

/**
 * 图（Graph）是由顶点的有穷非空集合和顶点之间边的集合组成，通常表示为：G(V,E)，其中，G表示一个图，V是图G中顶点的集合，E是图G中边的集合。
 *
 *  图的存储结构：
 *  1、邻接矩阵（数组）
 *  2、邻接表（链表）
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

}
