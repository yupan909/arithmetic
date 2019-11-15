package com.example.arithmetic.sort;

import java.util.Arrays;

/**
 * 《快速排序》
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

    public static int[] sort(int[] arr) {
        return quickSort(arr, 0, arr.length-1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //获取中轴元素所处的位置
            int mid = partition(arr, left, right);
            //进行分割
            arr = quickSort(arr, left, mid - 1);
            arr = quickSort(arr, mid + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        //选取中轴元素
        int pivot = arr[left];
        int i = left + 1;
        int j = right;
        while (true) {
            // 向右找到第一个大于 pivot 的元素位置，停止移动
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            // 向左找到第一个小于 pivot 的元素位置，停止移动
            while (i <= j && arr[j] >= pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            //交换两个元素的位置，使得左边的元素不大于pivot,右边的不小于pivot
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[j];
        // 使中轴元素处于有序的位置
        arr[j] = pivot;
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,8,6,2,7,5,3};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));
    }

}
