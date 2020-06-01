package com.example.datastructure.recursion;

/**
 * 递归回溯算法解决迷宫问题
 *
 * @author yupan@yijiupi.cn
 * @date 2020-05-29 15:18
 */
public class MiGong {
    /**
     * 用一个二维数组模拟迷宫
     */
    private int[][] map = new int[8][7];

    /**
     * 初始化迷宫   1：表示墙
     */
    public void init() {
        // 第一行和最后一行是墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 第一列和最后一列是墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 设置挡板
        map[4][1] = 1;
        map[4][2] = 1;
    }

    /**
     * 打印迷宫
     */
    public void print() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 7; j++) {
                System.out.printf("%d\t", map[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 寻路
     * 1、x, y表示小球从哪个位置出发
     * 2、如果小球能到达map[6][5],说明找到出口
     * 3、约定：0表示没走过，1表示是墙走不通，2表示可以走，3表示走过不通
     * 4、制定一个策略，下-》右-》上-》左
     */
    public boolean setWay(int x, int y) {
        if (map[6][5] == 2) {
            return true;
        } else if (map[x][y] == 0) {
            map[x][y] = 2;
            if (setWay(x+1, y)) {
                return true;
            } else if (setWay(x, y+1)) {
                return true;
            } else if (setWay(x-1, y)) {
                return true;
            } else if (setWay(x, y-1)) {
                return true;
            } else {
                map[x][y] = 3;
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MiGong miGong = new MiGong();
        miGong.init();
        miGong.print();
        System.out.println("开始寻路：");
        miGong.setWay(1, 1);
        miGong.print();
    }


}
