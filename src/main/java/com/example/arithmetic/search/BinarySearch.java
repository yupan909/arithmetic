package com.example.arithmetic.search;

/**
 * 《二分查找》时间复杂度: O(log2n)
 *     元素必须是有序的，如果是无序的则要先进行排序操作
 *
 * 【基本思想】
 *      也称为是折半查找，属于有序查找算法。用给定值k先与中间结点的关键字比较，中间结点把线形表分成两个子表，若相等则查找成功；
 *  若不相等，再根据k与该中间结点关键字的比较结果确定下一步查找哪个子表，这样递归进行，直到查找到或查找结束发现表中没有这样的结点。
 *
 *  复杂度分析：　
 *      最坏情况下，关键词比较次数为log2(n+1)，且期望时间复杂度为O(log2n)；
 *
 *  注：折半查找的前提条件是需要有序表顺序存储，对于静态查找表，一次排序后不再变化，折半查找能得到不错的效率。
 *      但对于需要频繁执行插入或删除操作的数据集来说，维护有序的排序会带来不小的工作量，那就不建议使用。
 */
public class BinarySearch {

    public static int search(int[] arr, int value){
        return binarySearch(arr, 0, arr.length-1, value);
    }

    /**
     * 递归方式
     */
    private static int binarySearch(int[] arr, int left, int right, int value){
        if (left > right) {
            return -1;
        }
        if (value == arr[left]) {
            return left;
        }
        if (value == arr[right]) {
            return right;
        }

        // 取中间索引
        int mid = (left + right) / 2;
        // 查找值小于中间值，则从左边继续查找
        if (value < arr[mid]) {
            return binarySearch(arr, left, mid-1, value);
        // 查找值小于中间值，则从右边继续查找
        } else if (value > arr[mid]) {
            return binarySearch(arr, mid+1, right, value);
        // 查找值等于中间值，则直接返回
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 7, 8, 10};
        int index = search(arr, 5);
        System.out.println("二分查找：" + index);
    }
}
