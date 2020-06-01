package com.example.datastructure.recursion;

import java.util.Arrays;

/**
 * 递归回溯算法解决八皇后问题
 *
 *   八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于1848年提出：
 *   在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 *
 * 思路分析：
 *   1、第一个皇后先放第一行第一列
 *   2、第二个皇后放在第二行第一列、然后判断是否OK[即判断是冲突]， 如果不OK，继续放在第二列、第三列、依次把所有列都放完，找到一个合适
 *   3、继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
 *   4、当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.
 *   5、然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4的步骤。
 *
 * @author yupan@yijiupi.cn
 * @date 2020-05-29 17:32
 */
public class Queen8 {

    /**
     * 表示一共有多少个皇后
     */
    private final static int MAX = 8;

    /**
     * 定义一个数组Array，保存皇后放置的结果，比如: arr={ 0,4,7,5,2,6,1,3 }  该数组的下标表示第几行，具体的值表示第几列。
     */
    private int[] arr = new int[MAX];

    /**
     * 记录共有多少种解法
     */
    private static int count = 0;

    /**
     * 这个方法用于表示放置第N个皇后，依次是第一行表示第一个，第二个表示第二个这样的思路.
     *
     * 过程:
     * 1.如果放置的是最后一个，则直接打印， 因为只有等于8的时候，表示是都放完了。
     * 否则
     * 1.因为是从第N个开始放，我们的设计就是从第N行开始计算，遍历8次，每次代表放在第N行的第几列
     * 2.判断是否冲突，
     * 3.如果没有冲突继续放下一行，直到放到最后一行完成。否则会进行回溯
     */
    public void put(int n) {
        // 表示8个皇后已经全部放置完，打印出来
        if (n == MAX) {
            print();
        } else {
            for(int i = 0; i < MAX; i++) {
                arr[n] = i;
                if (check(n)) {
                    put(n+1);
                }
            }
        }
    }

    /**
     * 检查当前皇后是否满足条件
     * @return
     */
    private boolean check(int n) {
        // n表示与之前的n次对比，是否有冲突
        for (int i = 0; i < n; i++) {
            // 判断是否有皇后与之前的皇后在同一列 或 同一斜线上
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印
     */
    private void print(){
        count++;
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.put(0);
        System.out.println("共有" + count + "种解法");
    }

}
