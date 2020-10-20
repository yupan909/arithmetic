package com.example.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 《基数排序》
 *      基数排序 (Radix Sort) 是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
 *   基数排序可以理解成是建立在“计数排序”的基础之上的一种排序算法。
 *   基数排序的发明可以追溯到 1887 年赫尔曼·何乐礼在打孔卡片制表机 (Tabulation Machine)上的贡献。
 *   基数排序法会使用到桶 (Bucket)，顾名思义，通过将要比较的位（个位、十位、百位…），将要排序的元素分配至 0~9 个桶中，
 *   借以达到排序的作用，在某些时候，基数排序法的效率高于其它的比较性排序法。
 *
 * 【基本思想】
 *      基数排序的排序思路是这样的：先以个位数的大小来对数据进行排序，接着以十位数的大小来多数进行排序，接着以百位数的大小……
 *   排到最后，就是一组有序的元素了。不过，他在以某位数进行排序的时候，是用“桶”来排序的。
 *   由于某位数（个位/十位….，不是一整个数）的大小范围为0-9，所以我们需要10个桶，然后把具有相同数值的数放进同一个桶里，
 *   之后再把桶里的数按照0号桶到9号桶的顺序取出来，这样一趟下来，按照某位数的排序就完成了
 *
 * 【算法步骤】
 *      1、找出最大数是几位数
 *      2、从最低位开始，依次进行一次排序
 *      3、从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列
 */
public class RadixSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 找出最大值
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // 计算最大值是几位数
        int num = 1;
        while (max / 10 > 0) {
            num++;
            max = max / 10;
        }

        // 创建10个桶
        List<List<Integer>> bucketList = new ArrayList<>(10);
        //初始化桶
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }

        // 进行每一趟的排序，从个位数开始排
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < n; j++) {
                // 获取每个数对应位数的数字
                int radio = (arr[j] / (int) Math.pow(10, i)) % 10;
                //放进对应的桶里
                bucketList.get(radio).add(arr[j]);
            }
            //合并放回原数组
            int k = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (Integer t : bucketList.get(j)) {
                    arr[k++] = t;
                }
                //取出来合并了之后把桶清光数据
                bucketList.get(j).clear();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = SortUtil.getArr(8);
        System.out.println("基数排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("基数排序后：" + Arrays.toString(arr));
    }
}
