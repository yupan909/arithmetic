package com.example.datastructure.array;

/**
 * 《解决约瑟夫问题》
 *  *       假设编号为1，2，3...n个人手拉手围坐在一圈，约定编号为k(1<= k <= n)的人开始报数，数到m的人出圈，
 *  *   他的下一位又从1开始报数，数到m的人又出圈，依次类推，直到剩余一个人即为胜出者，由此产生一个出圈编号的序列。
 *
 * @author yupan@yijiupi.cn
 * @date 2020-05-14 14:24
 */
public class Josephu {

    /**
     * 约瑟夫问题
     * @param n n个人围成圈
     * @param k 第k个人开始报数
     * @param m 数到m的人出圈
     *
     */
    public static void test(int n, int k, int m){
        // 组建n个人的数组
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        // 记录出圈人数
        int count = 0;
        // 移动步数
        int index = 0;
        // 开始报数的下标
        int startIndex = (k - 1) % n;
        while (true) {
            // 全部出圈，则退出
            if (count == n) {
                break;
            }
            // 记录步数，已出圈的跳过
            if (arr[startIndex] != 0) {
                index++;
            }
            // 数到m，则出圈
            if (index == m) {
                count++;
                if (count == n) {
                    System.out.println("最后出圈的节点：" + arr[startIndex]);
                } else {
                    System.out.println("出圈的节点：" + arr[startIndex]);
                }
                // 赋值为0，表示出圈
                arr[startIndex] = 0;
                index = 0;
            }
            // 继续往后数
            startIndex = (startIndex + 1) % n;
        }
    }

    public static void main(String[] args) {
        Josephu.test(5, 1, 2);
    }
}
