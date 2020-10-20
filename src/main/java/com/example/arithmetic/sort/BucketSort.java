package com.example.arithmetic.sort;

import java.util.*;

/**
 * 《桶排序》时间复杂度: O(n + k)
 *      桶排序(Bucket sort)是一种基于计数的排序算法（计数排序可参考上节的内容），
 *   桶排序是计数排序的扩展版本，计数排序可以看成每个桶只存储相同元素，而桶排序每个桶存储一定范围的元素，通过映射函数，
 *   将待排序数组中的元素映射到各个对应的桶中，对每个桶中的元素进行排序，最后将非空桶中的元素逐个放入原序列中。
 *   工作的原理是将数据分到有限数量的桶子里，然后每个桶再分别排序（有可能再使用别的排序算法或是以递回方式继续使用桶排序进行排序）
 *
 * 【基本思想】
 *      桶排序就是把最大值和最小值之间的数进行瓜分，例如分成10个区间，10个区间对应10个桶，我们把各元素放到对应区间的桶中去，
 *   再对每个桶中的数进行排序，可以采用归并排序，也可以采用快速排序之类的。之后每个桶里面的数据就是有序的了，我们在进行合并汇总。
 *
 * 【算法步骤】
 *      1、设置固定数量的空桶。
 *      2、把数据放到对应的桶中。
 *      3、对每个不为空的桶中数据进行排序。
 *      4、拼接不为空的桶中数据，得到结果。
 */
public class BucketSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 1、寻找数组的最大值与最小值，并算出差值d
        int n = arr.length;
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int d = max - min + 1;

        // 2、初始化桶，默认的桶数量=5
        int bucketNum = 5;
        List<List<Integer>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new ArrayList<>());
        }

        // 3、遍历原数组，将每个元素放入桶中
        for (int i = 0; i < n; i++) {
            // 每个桶的容量大小
            int bucketSize = (d + (bucketNum -1)) / bucketNum;
            // 利用映射函数将数据分配到各个桶中
            int num =  (arr[i] - min)  / bucketSize;
            bucketList.get(num).add(arr[i]);
        }

        // 4、对桶内的元素进行排序，我这里采用系统自带的排序工具
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketList.get(i));
        }

        // 5、把每个桶排序好的数据进行合并汇总放回原数组
        int k = 0;
        for (int i = 0; i < bucketNum; i++) {
            for (Integer t : bucketList.get(i)) {
                arr[k++] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtil.getArr(8);
        System.out.println("桶排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("桶排序后：" + Arrays.toString(arr));
    }

}
