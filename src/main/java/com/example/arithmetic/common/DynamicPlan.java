package com.example.arithmetic.common;

/**
 * 《动态规划算法》
 *      动态规划过程是：每次决策依赖于当前状态，又随即引起状态的转移。一个决策序列就是在变化的状态中产生出来的，所以，这种多阶段最优化决策解决问题的过程就称为动态规划。
 *
 *  基本思想与策略
 *      基本思想与分治法类似，也是将待求解的问题分解为若干个子问题（阶段），按顺序求解子阶段，前一子问题的解，为后一子问题的求解提供了有用的信息。
 *   在求解任一子问题时，列出各种可能的局部解，通过决策保留那些有可能达到最优的局部解，丢弃其他局部解。依次解决各子问题，最后一个子问题就是初始问题的解。
 *   由于动态规划解决的问题多数有重叠子问题这个特点，为减少重复计算，对每一个子问题只解一次，将其不同阶段的不同状态保存在一个二维数组中。
 *      与分治法最大的差别是：适合于用动态规划法求解的问题，经分解后得到的子问题往往不是互相独立的（即下一个子阶段的求解是建立在上一个子阶段的解的基础上，进行进一步的求解）。
 *
 *   公式：f(n,m) = max{f(n-1,m), f(n-1,m-w[n])+P(n,m)}
 *
 *  背包问题：
 *     给定一组物品，每种物品都有自己的重量和价格，在限定的总重量内，我们如何选择，才能使得物品的总价格最高。
 *
 *  例如：背包最大承受重量为4kg，
 *     产品A重量为1kg，价值1500元；
 *     产品B重量为4kg，价值3000元；
 *     产品C重量为3kg，价值2000元；
 *
 *                         0    1    2    3    4
 *                         |    |    |    |    |
 *                   0  -  0    0    0    0    0
 *            (1500) 1  -  0  1500 1500 1500 1500
 *            (3000) 4  -  0  1500 1500 1500 3000
 *            (2000) 3  -  0  1500 1500 2000 3500
 *
 * @author yupan
 * @date 1/4/21 4:11 PM
 */
public class DynamicPlan {

    /**
     * 背包问题
     * @param w 各物品的重量
     * @param v 各物品的价值
     * @param m 背包承受最大重量
     * @return 最大价值
     */
    private static int backpack(int w[], int v[], int m) {
        // boolArr布尔类型二维数组，用于记录当背包容量不变，而物品数量增多时，最大价值是否更新
        boolean[][] boolArr = new boolean[v.length + 1][m + 1];

        // 创建二维数组，v[i][j]表示前i个物品中能够装入容量为j的背包中的最大价值
        int[][] arr = new int[v.length + 1][m + 1];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                // 如果当前物品的重量大于背包的容量，则不能放置，表格中价值不变，就直接使用上一个单元格的数据：
                if (w[i-1] > j) {
                    arr[i][j] = arr[i-1][j];
                } else {
                    // 将新增后的最大价值与之前的最大价值进行比较，选其中大的值 -> Math.max(arr[i-1][j], arr[i-1][j-w[i-1]]+ v[i-1])
                    if (arr[i-1][j] < arr[i-1][j-w[i-1]] + v[i-1]) {
                        // 新增后的最大值 = 之前的物品能够装入剩下的背包容量的最大价值 + 新增物品的价值
                        arr[i][j] = arr[i-1][j-w[i-1]] + v[i-1];
                        // 记录更新
                        boolArr[i][j] = true;
                    } else {
                        arr[i][j] = arr[i-1][j];
                    }
                }
            }
        }

        // 查看表格的情况
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // 从后往前遍历，先定位到背包容量为capacity时的最大值处：
        // 在j=capacity列从下往上（i--）找到updateItem值为true时，说明往背包加入物品items[i-1]后，
        // 价值达到了最大，以后无论新增了多少可放入背包的物品，最大值都不再变化，背包里的物品已固定不变。
        // 而又因为最大值 = v[i-1] + table[i-1][j - w[i-1]]
        // 所以需要在j = j - w[i-1]列，查找达到最大值时所添加的物品
        // 如此循环，直到 j <= 0 或 i <= 0
        int i = arr.length - 1;
        int j = arr[0].length - 1;
        while (j > 0 && i > 0) {
            if (boolArr[i][j]) {
                System.out.println("将"+ v[i-1]+"放入背包");
                j -= w[i-1];
            }
            i--;
        }

        return arr[arr.length-1][arr[0].length-1];
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 4, 3};
        int[] v = new int[]{1500, 3000, 2000};
        int m = 4;
        System.out.println("最大价值：" + backpack(w, v, m));
    }
}
