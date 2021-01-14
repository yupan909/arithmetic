package com.example.arithmetic.common;


import java.util.ArrayList;

/**
 * 《骑士周游回溯算法》
 *
 *    马踏棋盘算法也被称为骑士周游问题，将马随机放在国际象棋的8X8棋盘，Board[0~7][0~7]的某个方格中，马按走棋规则(马走日字)进行移动。要求每个方格只进入一次，走遍棋盘上全部64个方格
 *
 *  骑士周游问题的解决步骤和思路
 *    1.创建棋盘chessBoard,是一个二维数组
 *    2.将当前位置设置为已经访问，然后根据当前位置，计算马儿还能走哪些位置，
 *      并放入到一个集合中(ArrayList),最多有8个位置，每走一步，就使用step+1
 *    3.遍历ArrayList中存放的所有位置，看看哪个可以走通,如果走通，就继续，走不通，就回溯
 *    4.判断马儿是否完成了任务,使用step 和应该走的步数比较,如果没有达到数量，则表示没有完成任务，将整个棋盘置0
 *  注意:马儿不同的走法(策略) ,会得到不同的结果，效率也会有影响(优化)
 *
 * @author yupan
 * @date 1/8/21 4:08 PM
 */
public class HorseChessboard {

    /**
     * 棋盘的行数
     */
    private int x;
    /**
     * 棋盘的列数
     */
    private int y;

    /**
     * 创建二维数组，表示棋盘
     */
    private int[][] chessboard;

    /**
     * 创建一个数组，标记棋盘的各个位置是否被访问过
     */
    private boolean visited[];

    /**
     * 使用一个属性，标记是否棋盘的所有位置都被访问过，如果是true,表示成功
     */
    private boolean finished;

    /**
     * 马儿的位置
     */
    private class Point{

        /**
         * 行数
         */
        private int x;

        /**
         * 列数
         */
        private int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Point(Point p) {
            this.x = p.x;
            this.y = p.y;
        }
    }

    public HorseChessboard(int x, int y) {
        this.x = x;
        this.y = y;
        this.chessboard = new int[x][y];
        this.visited = new boolean[x * y];
        this.finished = false;
    }

    /**
     * 从指定位置开始
     */
    public void start(int row, int column) {
        traversalChessboard(chessboard, row, column, 1);
        //输出棋盘的最后情况
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 完成骑士周游问题的算法
     *
     * @param chessboard 棋盘
     * @param row        马儿当前的位置的行 从0开始
     * @param column     马儿当前的位置的类 从0开始
     * @param step       是第几步，初始位置就是第1步
     */
    public void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        // 标记该位置已经访问
        visited[row * this.x + column] = true;
        // 获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(row, column));
        //遍历ps
        while (!ps.isEmpty()) {
            // 取出下一个可以走的位置
            Point p = ps.remove(0);
            // 判断该点是否已经访问过
            if (!visited[p.x * this.x + p.y]) {
                traversalChessboard(chessboard, p.x, p.y, step + 1);
            }
        }
        //判断马儿是否完成了任务，使用step 和应该走的步数比较
        //如果没有达到数量，刚表示没有完成任务，将整个棋盘置0
        //说明:step < X * Y  成立的情况有两种
        // 1、棋盘到目前位置，仍然没有走完
        //2、棋盘处于一个回溯过程
        if (step < this.x * this.y && !finished) {
            chessboard[row][column] = 0;
            visited[row * this.x + column] = false;
        } else {
            finished = true;
        }
    }

    /**
     * 功能:根据当前位置(Point)对象，计算马儿还能走哪些位置(Point)，并放入
     * 到一个集合中(ArrayList),最多有8个位置
     * @return
     */
    public ArrayList<Point> next(Point curPoint) {
        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<>();

        //创建一个Point
        Point p1 = new Point();
        //表示马儿可以走5这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //表示马儿可以走6这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //表示马儿可以走7这个位置
        if ((p1.x = curPoint.x + 1) < this.x && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //表示马儿可以走0这个位置
        if ((p1.x = curPoint.x + 2) < this.x && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //表示马儿可以走1这个位置
        if ((p1.x = curPoint.x + 2) < this.x && (p1.y = curPoint.y + 1) < this.y) {
            ps.add(new Point(p1));
        }
        //表示马儿可以走2这个位置
        if ((p1.x = curPoint.x + 1) < this.x && (p1.y = curPoint.y + 2) < this.y) {
            ps.add(new Point(p1));
        }
        //表示马儿可以走3这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < this.y) {
            ps.add(new Point(p1));
        }
        //表示马儿可以走4这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < this.y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    public static void main(String[] args) {
        HorseChessboard horseChessboard = new HorseChessboard(8, 8);
        long start = System.currentTimeMillis();
        horseChessboard.start(0,0);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }

}
