package com.example.arithmetic.common;

import java.util.*;

/**
 * 《贪心算法》
 *     贪心算法(贪婪算法)是指在对问题进行求解时，在每一步选择中都采取最好或者最优(即最有利)的选择，从而希望能够导致结果是最好或者最优的算法，
 *  贪心算法所得到的结果不一定是最优的结果(有时候会是最优解)，但是都是相对近似(接近)最优解的结果
 *
 *  最佳应用-集合覆盖
 *     假设存在如下表的需要付费的广播台，以及广播台信号可以覆盖的地区，如何选择最少的广播台，让所有的地区都可以接收到信号？
 *
 *       ｜ 广播  ｜   覆盖的地区   ｜
 *          K1     北京、上海、天津
 *          K2     广州、北京、深圳
 *          K3     成都、上海、杭州
 *          K4     上海、天津
 *          K5     杭州、大连
 *
 *  思路分析：
 *   目前并没有算法可以快速计算得到准备的值， 使用贪婪算法，则可以得到非常接近的解，并且效率高。选择策略上，因为需要覆盖全部地区的最小集合:
 *   (1)遍历所有的广播电台, 找到一个覆盖了最多未覆盖的地区的电台(此电台可能包含一些已覆盖的地区，但没有关系）
 *   (2)将这个电台加入到一个集合中(比如ArrayList), 想办法把该电台覆盖的地区在下次比较时去掉。
 *   (3)重复第1步直到覆盖了全部的地区
 *
 *  注意事项：
 *  (1)贪婪算法所得到的结果不一定是最优的结果(有时候会是最优解)，但是都是相对近似(接近)最优解的结果
 *  (2)比如上题的算法选出的是K1, K2, K3, K5，符合覆盖了全部的地区
 *  (3)但是我们发现 K2, K3,K4,K5 也可以覆盖全部地区，如果K2 的使用成本低于K1,那么我们上题的 K1, K2, K3, K5 虽然是满足条件，但是并不是最优的.
 *
 * @author yupan
 * @date 1/7/21 3:49 PM
 */
public class Greedy {

    /**
     * 贪心算法解决集合覆盖问题
     * @return
     */
    public static List<String> greedy(Map<String, Set<String>> broadcastMap) {
        // 已选择的广播
        List<String> broadcastList = new ArrayList<>();

        // 存放所有未覆盖地区的集合，初始时存放的是所有地区
        Set<String> allRegionSet = new HashSet<>();
        broadcastMap.forEach((k, v) -> {
            allRegionSet.addAll(v);
        });

        // 未覆盖地区为空时，表示全部覆盖，可以退出
        while(allRegionSet.size() != 0) {
            String maxKey = null;
            // 1、找到最多未覆盖的地区的电台
            for(Map.Entry<String, Set<String>> entry : broadcastMap.entrySet()) {
                if (maxKey == null) {
                    // 第一个地区直接当作最多未覆盖地区的电台
                    maxKey = entry.getKey();
                } else {
                    Set<String> tempRegionSet = entry.getValue();
                    // 获取当前地区对应的未覆盖的地区
                    tempRegionSet.retainAll(allRegionSet);
                    // 取对应的未覆盖的地区数量最多的电台
                    if (tempRegionSet.size() > broadcastMap.get(maxKey).size()) {
                        maxKey = entry.getKey();
                    }
                }
            }

            if (maxKey != null) {
                // 记录已选择的广播
                broadcastList.add(maxKey);

                // 2、把已选择的广播对应的地区从所有未覆盖地区的集合中移除掉
                Set<String> regionSet = broadcastMap.get(maxKey);
                allRegionSet.removeAll(regionSet);

                // 3、把已选择的广播从广播集合中移除
                broadcastMap.remove(maxKey);
            }
        }
        return broadcastList;
    }

    public static void main(String[] args) {
        Map<String, Set<String>> broadcastMap = new HashMap<>();
        Set<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        broadcastMap.put("K1", hashSet1);

        Set<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        broadcastMap.put("K2", hashSet2);

        Set<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        broadcastMap.put("K3", hashSet3);

        Set<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        broadcastMap.put("K4", hashSet4);

        Set<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        broadcastMap.put("K5", hashSet5);

        List<String> broadcastList = greedy(broadcastMap);
        System.out.println("贪心算法：" + Arrays.toString(broadcastList.toArray()));
    }
}
