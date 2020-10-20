package com.example.arithmetic.search;

/**
 * 《顺序查找》时间复杂度: O(n)
 *     顺序查找适合于存储结构为顺序存储或链接存储的线性表
 *
 * 【基本思想】
 *      顺序查找也称为线性查找，属于无序查找算法。从数据结构线形表的一端开始，顺序扫描，依次将扫描到的结点关键字与给定值k相比较，
 *  若相等则表示查找成功；若扫描结束仍没有找到关键字等于k的结点，表示查找失败。
 *
 *  复杂度分析：　
 * 　　查找成功时的平均查找长度为：（假设每个数据元素的概率相等） ASL = 1/n(1+2+3+…+n) = (n+1)/2 ;
 * 　　当查找不成功时，需要n+1次比较，时间复杂度为O(n);所以，顺序查找的时间复杂度为O(n)。
 */
public class SequenceSearch {

    public static int search(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 8, 10, 7};
        int index = search(arr, 10);
        System.out.println("线性查找：" + index);
    }
}
