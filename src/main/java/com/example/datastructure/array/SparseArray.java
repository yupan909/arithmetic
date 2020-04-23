package com.example.datastructure.array;

/**
 * 稀疏数组
 *
 *  如果一个数组(包括多维数组)中的大部分元素为0，或者为同一个值的数组时，可以使用稀疏数组来保存该数组，节约空间。
 *  一般来说，稀疏数组的处理方法是：
 *      1.记录数组一共有几行几列，有多少个不同的数值。
 *      2.把具有不同值的元素的行列及记录在一个小规模的数组中，从而缩小程序的规模。
 *
 *  二维数组转稀疏数组的思路：
 *      1、遍历二维数组，得到有效个数sum。
 *      2、根据sum就可以创建稀疏数组sparseArr int[sum+1][3]
 *      3、将二维数组的有效数据存入稀疏数组。
 *
 *  稀疏数组转原始的二维数组思路：
 *      1、先读取稀疏数组的第一行，根据第一行数据，创建原始的二维数组。
 *      2、在读取稀疏数组后几行的数据，并赋给原始的二维数组即可。
 *
 * @author yupan@yijiupi.cn
 * @date 2020-04-21 17:16
 */
public class SparseArray {

    public static void main(String[] args) {
        // 1、创建一个原始的二维数组   0：表示没有棋子 1：表示黑子 2：表示白子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 1;
        chessArr[3][3] = 2;
        chessArr[3][4] = 2;
        System.out.println("原始的二维数组：");
        printArr(chessArr);

        System.out.println();

        // 2、二维数组转成稀疏数组
        // （1）获取非0的元素个数
        int sum = 0;
        for (int i = 0 ; i < chessArr.length ; i++) {
            for(int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        // （2）创建稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        // 稀疏数组第一行记录原二维数组的行+列+非0元素个数
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 非0元素分别存入剩余行
        int count = 0;
        for (int i = 0 ; i < chessArr.length ; i++) {
            for(int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        System.out.println("二维数组转稀疏数组：");
        printArr(sparseArr);

        System.out.println();

        // 3、稀疏数组还原成二维数组
        int[][] oldArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1 ; i < sparseArr.length ; i++) {
            oldArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("稀疏数组还原成二维数组：");
        printArr(oldArr);

    }

    /**
     * 打印数组
     */
    public static void printArr(int[][] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }
}
