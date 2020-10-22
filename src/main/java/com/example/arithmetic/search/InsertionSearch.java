package com.example.arithmetic.search;

/**
 * 《插值查找》时间复杂度: O(log2(log2n))
 *
 * 【基本思想】
 *      是二分查找的一种优化，将查找点改进为自适应选择以提高查找效率。
 *  将mid = (low + high) / 2 取中值的取法换成了 mid = low + (key - a[low]) / (a[high] - a[low]) * (high - low)
 *  当然，差值查找也属于有序查找。
 *
 *  复杂度分析：　
 *      查找成功或者失败的时间复杂度均为O(log2(log2n))
 *
 *  注：对于表长较大，而关键字分布又比较均匀的查找表来说，插值查找算法的平均性能比折半查找要好的多。
 *     反之，数组中如果分布非常不均匀，那么插值查找未必是很合适的选择。
 */
public class InsertionSearch {

    public static int search(int[] arr, int value){
        return insertionSearch(arr, 0, arr.length-1, value);
    }

    public static int insertionSearch(int[] arr, int left, int right, int value){
        if (left > right) {
            return -1;
        }
        if (value == arr[left]) {
            return left;
        }
        if (value == arr[right]) {
            return right;
        }

        // 自适应获取索引
        int mid = left + (value - arr[left]) / (arr[right] - arr[left]) * (right - left);
        // 查找值小于中间值，则从左边继续查找
        if (value < arr[mid]) {
            return insertionSearch(arr, left, mid-1, value);
        // 查找值小于中间值，则从右边继续查找
        } else if (value > arr[mid]) {
            return insertionSearch(arr, mid+1, right, value);
        // 查找值等于中间值，则直接返回
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = search(arr, 1);
        System.out.println("插值查找：" + index);
    }
}
