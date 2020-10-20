package com.example.arithmetic.sort;

import java.util.Arrays;

/**
 * 《堆排序》时间复杂度: O(n log n)
 *
 *       堆排序（Heapsort）是指利用堆这种数据结构（后面的【图解数据结构】内容会讲解分析）所设计的一种排序算法。
 *   堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 *   堆排序可以说是一种利用堆的概念来排序的选择排序。分为两种方法：
 *      （1）大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
 *      （2）小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
 *
 *   堆是具有以下性质的完全二叉树：
 *       每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。
 *       二叉树一般是采用链表的方式来实现的，但二叉堆我们是采用数组的方式来存储的。
 *       假如一个节点的下标为n，则可以求得它左孩子的下标为：2n+1；右孩子下标为：2n+2。
 *
 * 【基本思想】
 *      堆排序就是把堆顶的元素与最后一个元素交换，交换之后破坏了堆的特性，我们再把堆中剩余的元素再次构成一个大顶堆，
 *   然后再把堆顶元素与最后第二个元素交换….如此往复下去，等到剩余的元素只有一个的时候，此时的数组就是有序的了。
 *
 * 【算法步骤】
 *      1、创建一个堆 H[0……n-1]；
 *      2、把堆首（最大值）和堆尾互换；
 *      3、把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
 *      4、重复步骤 2，直到堆的尺寸为 1。
 */
public class HeapSort {

    public static int[] sort(int[] arr) {
        int len = arr.length;

        // 构建二叉堆
        buildMaxHeap(arr, len);

        // 进行堆排序
        for (int i = len - 1; i > 0; i--) {
            // 把堆顶的元素与最后一个元素交换
            swap(arr, 0, i);

            len--;

            // 堆中剩余的元素重新调整，再次构成大顶堆
            heapify(arr, 0, len);
        }
        return arr;
    }

    /**
     * 建立大顶堆
     */
    public static void buildMaxHeap(int[] arr, int len) {
        // 构建二叉堆
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    /**
     * 堆调整，构成大顶堆
     */
    private static void heapify(int[] arr, int i, int len) {
        // 定位左孩子节点位置
        int left = 2 * i + 1;
        // 定位右孩子节点位置
        int right = 2 * i + 2;
        // 临时保证要下沉的元素位置
        int largest = i;

        // 如果小于左节点，则交换位置
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        // 如果小于右节点，则交换位置
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            // 继续下沉
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,8,6,2,7,5,3};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));
    }

}
