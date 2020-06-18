package com.example.arithmetic.sort;

import java.util.Arrays;

/**
 * 《希尔排序》
 *
 *     希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法。
 *     希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 *      （1）插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
 *      （2）但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位；
 *
 * 【基本思想】
 *      采用插入排序的方法，先让数组中任意间隔为 h 的元素有序，刚开始 h 的大小可以是 h = n / 2,
 *   接着让 h = n / 4，让 h 一直缩小，当 h = 1 时，也就是此时数组中任意间隔为1的元素有序，此时的数组就是有序的了。
 *
 * 【算法步骤】
 *      1、选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
 *      2、按增量序列个数 k，对序列进行 k 趟排序；
 *      3、每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。
 *         仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort {

    public static void sort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        //  对每组间隔为gap的分组进行排序，刚开始 gap = n / 2;
        for (int gap = n / 2; gap > 0; gap /= 2){
            // 对各个局部分组进行插入排序
            for (int i = gap; i < n; i++) {
                // 插入排序
                int temp = arr[i];
                int j = i;
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                if (j != i) {
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[8];
        for(int i=0; i<arr.length;i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("希尔排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("希尔排序后：" + Arrays.toString(arr));
    }

}
