package com.example.arithmetic.common;

/**
 * 《二分查找》（非递归）
 *
 *  思路分析
 *    1.对升序数组进行查找，查找具体的值所对应的索引
 *    2.取中间索引跟目标值进行比较，
 *     （1）如果目标值=中间值，则返回中间值索引；
 *     （2）如果目标值>中间值，则左边索引为中间索引+1；
 *     （3）如果目标值<中间值，则右边索引为中间索引-1;
 *    左侧<=右侧索引时进行以上处理，否则就是没有找到返回-1
 *
 * @author yupan
 * @date 12/31/20 3:29 PM
 */
public class BinarySearch {

    /**
     * 二分查找（非递归）
     * @return
     */
    public static int search(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (value < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 7, 8, 10};
        int index = search(arr, 7);
        System.out.println("二分查找（非递归）：" + index);
    }
}
