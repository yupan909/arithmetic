package com.example.arithmetic.sort;

import java.util.Arrays;

/**
 * 《快速排序》时间复杂度: O(n log n)
 *
 *    快速排序是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序 n 个项目要 Ο(nlogn) 次比较。
 *    在最坏状况下则需要 Ο(n2) 次比较，但这种状况并不常见。事实上，快速排序通常明显比其他 Ο(nlogn) 算法更快，
 *    因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来。
 *    快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
 *    快速排序又是一种分而治之思想在排序算法上的典型应用。本质上来看，快速排序应该算是在冒泡排序基础上的递归分治法。
 *
 * 【基本思想】
 *      我们从数组中选择一个元素，我们把这个元素称之为中轴元素吧，然后把数组中所有小于中轴元素的元素放在其左边，
 *   所有大于或等于中轴元素的元素放在其右边，显然，此时中轴元素所处的位置的是有序的。也就是说，我们无需再移动中轴元素的位置。
 *   从中轴元素那里开始把大的数组切割成两个小的数组(两个数组都不包含中轴元素)，接着我们通过递归的方式，让中轴元素左边的数组和
 *   右边的数组也重复同样的操作，直到数组的大小为1，此时每个元素都处于有序的位置。
 *
 * 【算法步骤】
 *      1、从数列中挑出一个元素，称为 “基准”（pivot）;
 *      2、重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 *         在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 *      3、递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
 */
public class QuickSort {

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        // 三分取基准法(优化)
        mid(arr, start, end);
        // 找出基准元素，默认取第一个元素
        int pivot = arr[start];
        // 左边位置
        int left = start;
        // 右边位置
        int right = end;

        while (left < right) {
            //（1）从右开始找到比基准小的数
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            // 放在左边
            if (left < right) {
                arr[left++] = arr[right];
            }

            //（2）从左开始找到比基准大的数
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 放在右边
            if (left < right) {
                arr[right--] = arr[left];
            }
        }
        // 交换基准数
        arr[left] = pivot;

        // 递归排序左子数组
        quickSort(arr, start, left - 1);
        // 递归排序右子数组
        quickSort(arr, left + 1, end);
    }

    /**
     * 三分取基准法
     */
    private static void mid(int[] arr, int start, int end) {
        // 每次找基准前让(low+high)/2中得到mid元素，然后让array[mid] < array[low] < array[high]
        int mid = (end + start) / 2;
        // mid和end对应的大的数给array[end]
        if (arr[mid] > arr[end]) {
            swap(arr, mid, end);
        }
        // start和end对应的大的数给array[end]
        if (arr[start] > arr[end]) {
            swap(arr, start, end);
        }
        // mid和start对应的大的数给array[start]
        if (arr[mid] > arr[start]) {
            swap(arr, mid, start);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = SortUtil.getArr(8);
        System.out.println("快速排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("快速排序后：" + Arrays.toString(arr));
    }

}
