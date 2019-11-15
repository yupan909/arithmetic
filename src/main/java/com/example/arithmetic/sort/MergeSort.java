package com.example.arithmetic.sort;

import java.util.Arrays;

/**
 * 《归并排序》
 *
 *    归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 *    作为一种典型的分而治之思想的算法应用，归并排序的实现由两种方法：
 *      （1）自上而下的递归（所有递归的方法都可以用迭代重写，所以就有了第 2 种方法）；
 *      （2）自下而上的迭代；
 *    和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是 O(nlogn) 的时间复杂度。代价是需要额外的内存空间。
*
 * 【基本思想】
 *      将一个大的无序数组有序，我们可以把大的数组分成两个，然后对这两个数组分别进行排序，之后在把这两个数组合并成一个有序的数组。
 *   由于两个小的数组都是有序的，所以在合并的时候是很快的。通过递归的方式将大的数组一直分割，直到数组的大小为 1，此时只有一个元素，
 *   那么该数组就是有序的了，之后再把两个数组大小为1的合并成一个大小为2的，再把两个大小为2的合并成4的 ….. 直到全部小的数组合并起来。
 *
 * 【算法步骤】
 *      1、申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 *      2、设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 *      3、比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 *      4、重复步骤 3 直到某一指针达到序列尾；
 *      5、将另一序列剩下的所有元素直接复制到合并序列尾。
 */
public class MergeSort {

    public static int[] sort(int[] arr){
        if (arr == null || arr.length < 2) {
            return arr;
        }
        // 拆分成两个数组
        int middle = (int)Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    /**
     * 合并函数，把两个有序的数组合并起来
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,8,6,2,7,5,3};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));
    }

}
