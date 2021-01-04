package com.example.arithmetic.common;

/**
 * 《分治算法》
 *      分治”从字面上解释就是“分而治之”，将一个复杂的问题分解成为两个或者更多的相同或者相似的子问题，再把子问题分成更小的子问题，
 *  直到最后的子问题简单到可以直接求解，原问题的解就是子问题解的合并。
 *
 *  分治算法的基本步骤
 *     1.分解：将原问题分解为若干个规模较小，相互独立，和原问题形式相同子问题
 *     2.解决:  若子问题规模较小，而容易被解决的直接解决，否则递归解决各个子问题
 *     3.合并:  将各个子问题的解合并为原问题的解
 *
 *  汉诺塔问题：
 *     存在三根柱子（ABC）,柱子上存在着若干小圆盘，要求把小圆盘从最左边的柱子搬运到最右边，要求小的圆盘需要在大的盘子上面,上面的盘比下面的盘先动（所有圆盘的初始位置在最左边）
 *  分析思路:
 *    1.如果只有一个盘，从A杆到C杆直接 A->C即可
 *    2.如果有两个盘的话，先把上面一个盘 A->B,然后把下面一个盘 A->C,然后把上面一个盘从B->C
 *    3.如果有两个盘及其以上，可以将所有的盘看做两部分（一部分是最下面一个，一部分是上面的所有个）
 *    4.先把上面的所有盘 A->B,最下面这个盘从A->C,然后把B杆中的所有盘搬运到C杆
 *
 * @author yupan
 * @date 12/31/20 5:33 PM
 */
public class DivideAndConquer {

    /**
     * 汉诺塔问题
     */
    private static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            // 1.先把上面所有盘从a->b
            hanoiTower(num - 1, a, c, b);
            // 2.最下面这个盘从a->c
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            // 3.最后把b上所有盘移到c
            hanoiTower(num - 1, b, a, c);
        }
    }

    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }
}
