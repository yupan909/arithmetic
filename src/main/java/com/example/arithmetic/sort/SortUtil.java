package com.example.arithmetic.sort;

/**
 * 排序工具类
 *
 * @author yupan@yijiupi.cn
 * @date 2020-06-18 16:38
 */
public class SortUtil {

    /**
     * 随机创建指定长度的数组
     * @return
     */
    public static int[] getArr(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }
}
