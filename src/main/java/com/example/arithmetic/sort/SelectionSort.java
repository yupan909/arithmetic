package com.example.arithmetic.sort;

import java.util.Arrays;

/**
 * 《选择排序》
 *
 *     选择排序是一种简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。所以用到它的时候，数据规模越小越好。
 *   唯一的好处可能就是不占用额外的内存空间了吧。
 *
 * 【基本思想】
 *      首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。
 *   其次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。这种方法我们称之为选择排序。
 *
 * 【算法步骤】
 *      1、首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 *      2、再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *      3、重复第二步，直到所有元素均排序完毕。
 */
public class SelectionSort {

    public static void sort(int[] arr){
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-(i+1)
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前的最小元素
                    min = j;
                }
            }

            // 每轮结束后，将最小的元素与i位置元素进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtil.getArr(8);
        System.out.println("选择排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("选择排序后：" + Arrays.toString(arr));
    }

}
