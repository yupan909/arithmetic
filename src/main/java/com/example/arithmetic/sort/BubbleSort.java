package com.example.arithmetic.sort;

import java.util.Arrays;

/**
 * 《冒泡排序》时间复杂度: O(n^2)
 *
 *     冒泡排序（Bubble Sort）也是一种简单直观的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果
 *  他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 *  这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 *
 * 【基本思想】
 *      把第一个元素与第二个元素比较，如果第一个比第二个大，则交换他们的位置。接着继续比较第二个与第三个元素，
 *   如果第二个比第三个大，则交换他们的位置… 我们对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，
 *   这样一趟比较交换下来之后，排在最右的元素就会是最大的数。除去最右的元素，我们对剩余的元素做同样的工作，如此重复下去，直到排序完成。
 *
 * 【算法步骤】
 *      1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 *      2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 *      3、针对所有的元素重复以上的步骤，每次可以少比较倒数一个数。
 *      4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort {

    public static void sort(int[] arr){
        // 假设需要排序N个数，则最多需要比较的轮数为N-1
        for (int i = 0; i < arr.length - 1; i++) {
            // 设置一个标识，如果本次循环没有交换位置，则表示排序完成，可以退出
            boolean flag = true;
            // 每比较一轮，倒数第N个数就不需要参与比较
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtil.getArr(8);
        System.out.println("冒泡排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("冒泡排序后：" + Arrays.toString(arr));
    }

}
