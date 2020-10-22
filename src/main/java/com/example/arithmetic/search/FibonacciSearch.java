package com.example.arithmetic.search;

import java.util.Arrays;

/**
 * 《斐波那契查找》时间复杂度: O(log2n)
 *      在介绍斐波那契查找算法之前，我们先介绍一下很它紧密相连并且大家都熟知的一个概念——黄金分割。
 * 　黄金比例又称黄金分割，是指事物各部分间一定的数学比例关系，即将整体一分为二，较大部分与较小部分之比等于整体与较大部分之比，其比值约为1:0.618或1.618:1。
 *   0.618被公认为最具有审美意义的比例数字，这个数值的作用不仅仅体现在诸如绘画、雕塑、音乐、建筑等艺术领域，而且在管理、工程设计等方面也有着不可忽视的作用。
 *   因此被称为黄金分割。
 * 　　 大家记不记得斐波那契数列：1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89…….（从第三个数开始，后边每一个数都是前两个数的和）。
 *   然后我们会发现，随着斐波那契数列的递增，前后两个数的比值会越来越接近0.618，利用这个特性，我们就可以将黄金比例运用到查找技术中。
 *
 * 【基本思想】
 *      也是二分查找的一种提升算法，通过运用黄金比例的概念在数列中选择查找点进行查找，提高查找效率。同样地，斐波那契查找也属于一种有序查找算法
 *  他要求开始表中记录的个数为某个斐波那契数小1，及n=F(k)-1;然后需要装填一个长度为n的新数组，且mid = low + fib(k - 1) - 1，k为fib(k) - 1刚好大于原数组长度的那个值。
 *      开始将k值与第F(k-1)位置的记录进行比较(及mid=low+F(k-1)-1),比较结果也分为三种
 *      1）相等，mid位置的元素即为所求
 *      2）>，low=mid+1,k-=2;
 *        说明：low=mid+1说明待查找的元素在[mid+1,high]范围内，k-=2 说明范围[mid+1,high]内的元素个数为n-(F(k-1))= Fk-1-F(k-1)=Fk-F(k-1)-1=F(k-2)-1个，
 *        所以可以递归的应用斐波那契查找。
 *      3）<，high=mid-1,k-=1。
 *        说明：low=mid+1说明待查找的元素在[low,mid-1]范围内，k-=1 说明范围[low,mid-1]内的元素个数为F(k-1)-1个，所以可以递归 的应用斐波那契查找。
 *
 *  注：首先要明确：如果一个有序表的元素个数为n,并且n正好是（某个斐波那契数 - 1），即n=F[k]-1时，才能用斐波那契查找法。
 *      如果有序表的元素个n不等于（某个斐波那契数 - 1），即n≠F[k]-1，这时必须要将有序表的元素扩展到大于n的那个斐波那契数 - 1才行
 */
public class FibonacciSearch {

    public static int search(int[] arr, int value){
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        // 获取一个斐波那契数列
        int f[] = fib();
        // 表示斐波那契分割数值的下标
        int k = 0;
        // 获取斐波那契分割数值的下标
        while (high > f[k] -1) {
            k++;
        }
        // 因为f[k]的值可能大于arr的长度，因此我们需要扩展arr
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        // 循环开始寻找
        while (low <= high) {
            mid = low + f[k-1] - 1;
            // 说明待查找的元素在[low,mid-1]
            if (value < temp[mid]) {
                high = mid - 1;
                /*全部元素=前部元素+后部元素
                 * f[k]=f[k-1]+f[k-2]
                 * 因为前部有f[k-1]个元素,所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
                 * 即在f[k-1]的前部继续查找 所以k--
                 * 即下次循环 mid=f[k-1-1]-1
                 * */
                k--;
            } else if (value > temp[mid]) {
                low = mid + 1;
                /*全部元素=前部元素+后部元素
                 * f[k]=f[k-1]+f[k-2]
                 * 因为后部有f[k-2]个元素,所以可以继续拆分f[k-2]=f[k-3]+f[k-4]
                 * 即在f[k-2]的前部继续查找 所以k-=2
                 * 即下次循环 mid=f[k-1-2]-1
                 * */
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

    /**
     * 创建一个斐波那契数列
     * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89…….（从第三个数开始，后边每一个数都是前两个数的和）
     */
    private static int[] fib(){
        int maxSize = 20;
        int[] fib = new int[maxSize];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 20, 42, 100, 101};
        int index = search(arr,  101);
        System.out.println("斐波那契查找：" + index);
    }
}
