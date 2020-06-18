package com.example.arithmetic.sort;

import java.util.Arrays;

/**
 * 《插入排序》
 *
 *     插入排序的代码实现虽然没有冒泡排序和选择排序那么简单粗暴，但它的原理应该是最容易理解的了，因为只要打过扑
 *  克牌的人都应该能够秒懂。插入排序是一种最简单直观的排序算法，它的工作原理是通过构建有序序列，对于未排序数据，
 *  在已排序序列中从后向前扫描，找到相应位置并插入。
 *
 * 【基本思想】
 *      1、从数组第2个元素开始抽取元素。
 *      2、把它与左边第一个元素比较，如果左边第一个元素比它大，则继续与左边第二个元素比较下去，直到遇到不比它大的元素，然后插到这个元素的右边。
 *      3、继续选取第3，4，….n个元素,重复步骤 2 ，选择适当的位置插入。
 *
 * 【算法步骤】
 *     1、将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 *     2、从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
 *     （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class InsertionSort {

    public static void sort(int[] arr){
        // 从下标为1的元素开始选择合适的位置插入
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边开始比较，找到比其小的数
            int j = i;
            while(j > 0 && tmp < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtil.getArr(8);
        System.out.println("插入排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("插入排序后：" + Arrays.toString(arr));
    }

}
