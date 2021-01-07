package com.example.arithmetic.common;

/**
 * 《KMP算法》
 *    KMP算法是一种改进的字符串匹配算法，由D.E.Knuth，J.H.Morris和V.R.Pratt提出的，因此人们称它为克努特—莫里斯—普拉特操作（简称KMP算法）。
 *  KMP算法的核心是利用匹配失败后的信息，尽量减少模式串与主串的匹配次数以达到快速匹配的目的。具体实现就是通过一个next()函数实现，函数本身包含了模式串的局部匹配信息。KMP算法的时间复杂度O(m+n)。
 *  KMP算法是在一个母字符串中查找一个子字符串的高效算法。该算法相对于 Brute-Force（暴力）算法有比较大的改进，它可以在匹配过程中失配的情况下，有效地多往后面跳几个字符，加快匹配速度。
 *
 *    部分匹配表：KMP算法中有个数组，叫做前缀数组，也有的叫next数组，每一个子串有一个固定的next数组，它记录着字符串匹配过程中失配情况下可以向前多跳几个字符。
 * 当然它描述的也是子串的对称程度,程度越高，值越大，当然之前可能出现再匹配的机会就更大。
 *
 *    [搜索词]    A B C D A B D
 *  [部分匹配值]  0 0 0 0 1 2 0
 *
 *  “部分匹配值”就是”前缀”和”后缀”的最长的共有元素的长度。以”ABCDABD”为例，
 *      －”A”的前缀和后缀都为空集，共有元素的长度为0；
 *      －”AB”的前缀为[A]，后缀为[B]，共有元素的长度为0；
 *      －”ABC”的前缀为[A, AB]，后缀为[BC, C]，共有元素的长度0；
 *      －”ABCD”的前缀为[A, AB, ABC]，后缀为[BCD, CD, D]，共有元素的长度为0；
 *      －”ABCDA”的前缀为[A, AB, ABC, ABCD]，后缀为[BCDA, CDA, DA, A]，共有元素为”A”，长度为1；
 *      －”ABCDAB”的前缀为[A, AB, ABC, ABCD, ABCDA]，后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为”AB”，长度为2；
 *      －”ABCDABD”的前缀为[A, AB, ABC, ABCD, ABCDA, ABCDAB]，后缀为[BCDABD, CDABD, DABD, ABD, BD, D]，共有元素的长度为0。
 *
 * @author yupan
 * @date 1/5/21 11:38 AM
 */
public class KMP {

    /**
     * KMP算法匹配字符串，返回字符串第一次出现的位置
     * @return
     */
    public static int kmpSearch(String src, String dest) {
        // 获取部分匹配值的next数组
        int[] next = kmpNext(dest);
        for (int i = 0, j = 0; i < src.length(); i++) {
            while(j > 0 && src.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }
            if (src.charAt(i) == dest.charAt(j)) {
                j++;
            }
            // 表示全部匹配
            if (j == dest.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 获取部分匹配值的next数组
     * @return
     */
    private static int[] kmpNext(String dest) {
        // 创建一个next数组存储部分匹配值
        int[] next = new int[dest.length()];
        // 如果字符串长度是1，则部分匹配值为0
        next[0] = 0;
        for (int i = 1, j = 0; i < next.length; i++) {
            while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }
            // 满足条件时部分匹配值+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        String src = "BBC ABCDAB ABCDABCDABDE";
        String dest = "ABCDABD";
        System.out.println("KMP算法：" + kmpSearch(src, dest));
    }
}

