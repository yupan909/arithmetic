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

    public static void sort(int[] arr) {
        // 1、构建二叉堆
        for (int i = arr.length/2-1; i >= 0; i--) {
            // 从第一个非叶子结点（arr.length/2-1）从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        // 2、调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            // 将堆顶元素与末尾元素进行交换
            swap(arr, 0, i);
            // 重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     */
    private static void adjustHeap(int[] arr, int i, int len) {
        // 先取出当前元素i
        int temp = arr[i];
        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int k = 2 * i + 1; k < len; k = k * 2 + 1) {
            // 1、如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < len && arr[k] < arr[k+1]) {
                k++;
            }

            // 2、如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                // 如果父结点的值已经大于孩子结点的值，则直接结束
                break;
            }
        }
        // 将temp值放到最终的位置
        arr[i] = temp;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = SortUtil.getArr(8);
        System.out.println("堆排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("堆排序后：" + Arrays.toString(arr));
    }

}
