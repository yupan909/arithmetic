package com.example.arithmetic.sort;

import java.util.Arrays;

/**
 * 《计数排序》时间复杂度: O(n + k)
 *
 *      计数排序是一种非基于比较的排序算法，其空间复杂度和时间复杂度均为O(n+k)，其中k是整数的范围。
 *   基于比较的排序算法时间复杂度最小是O(nlogn)的。该算法于1954年由 Harold H. Seward 提出。
 *   计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。作为一种线性时间复杂度的排序，
 *   计数排序要求输入的数据必须是有确定范围的整数。计数排序是一种适合于最大值和最小值的差值不是不是很大的排序。
 *
 * 【基本思想】
 *      就是把数组元素作为数组的下标，然后用一个临时数组统计该元素出现的次数，例如 temp[i] = m, 表示元素 i 一共出现了 m 次。
 *   最后再把临时数组统计的数据从小到大汇总起来，此时汇总起来是数据是有序的。
 *
 * 【算法步骤】
 *      1、花O(n)的时间扫描一下整个序列 A，获取最小值 min 和最大值 max
 *      2、开辟一块新的空间创建新的数组 B，长度为 ( max - min + 1)
 *      3、数组 B 中 index 的元素记录的值是 A 中某元素出现的次数
 *      4、最后输出目标整数序列，具体的逻辑是遍历数组 B，输出相应元素以及对应的个数
 */
public class CountingSort {

    public static void sort(int[] arr){
        // 1.得到数列的最大值和最小值，并算出差值d
        int n = arr.length;
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        int d = max - min + 1;

        // 2.创建统计数组并统计对应元素个数
        int[] temp = new int[d];
        for (int i = 0; i < n; i++) {
            temp[arr[i] - min]++;
        }

        // 3.把临时数组统计好的数据汇总到原数组
        int k = 0;
        for (int i = 0; i < d; i++) {
            for (int j = temp[i]; j > 0; j--) {
                arr[k++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtil.getArr(8);
        System.out.println("计数排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("计数排序后：" + Arrays.toString(arr));
    }

}
