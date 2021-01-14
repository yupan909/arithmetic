package com.example.arithmetic.box;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 一维装箱（体积）
 *
 * （现将若干个产品装入不同规格的箱子中，推荐最优的装箱方案，最优指的是箱子数量最少，规格最小）
 *
 * @author yupan
 * @date 2020-11-02 17:51
 */
public class BoxUtil {

    /**
     * 不同规格箱子集合
     */
    private List<Box> boxModelList;

    /**
     * 产品集合
     */
    private List<Product> productList;

    public BoxUtil(List<Box> boxModelList, List<Product> productList) {
        this.boxModelList = boxModelList;
        this.productList = productList;
    }

    /**
     * 获取推荐箱子
     * @return
     */
    public List<Box> getBox() {
        // 如果箱子规格集合为空，则直接退出
        if (CollectionUtils.isEmpty(boxModelList)) {
            return null;
        }
        // 过滤出装不下的产品
        filterProduct();
        if (CollectionUtils.isEmpty(productList)) {
            return null;
        }
        // 开始装箱
        List<List<Box>> allBoxList = new ArrayList<>();
        List<Box> boxList = new ArrayList<>();
        allot(allBoxList, boxList, productList);
        return getOptimalResult(allBoxList);
    }

    /**
     * 根据所有装箱方式获取最优解
     *  (优先箱子数最小，其次箱子体积最小)
     */
    private List<Box> getOptimalResult(List<List<Box>> boxList) {
        if (CollectionUtils.isEmpty(boxList)) {
            return null;
        }
        // 1、找出箱子数最少的的装箱方式
        Map<Integer, List<List<Box>>> minBoxMap = boxList.stream().collect(Collectors.groupingBy(p -> p.size()));
        List<Integer> keyList = minBoxMap.keySet().stream().sorted().collect(Collectors.toList());
        List<List<Box>> minBoxList = minBoxMap.get(keyList.get(0));
        if (minBoxList.size() == 1) {
            return minBoxList.get(0);
        }
        // 2、从箱子数最小的方式中找出箱子总体积最小的方式
        Map<Integer, List<List<Box>>> minVolumeMap = minBoxList.stream().collect(Collectors.groupingBy(p -> p.stream().mapToInt(q -> q.getVolume()).sum()));
        List<Integer> volumeList = minVolumeMap.keySet().stream().sorted().collect(Collectors.toList());
        List<List<Box>> minVolumeList = minVolumeMap.get(volumeList.get(0));
        return minVolumeList.get(0);
    }

    /**
     * 分配装箱
     */
    private void allot(List<List<Box>> allBoxList, List<Box> boxList, List<Product> productList) {
        if (CollectionUtils.isEmpty(productList)) {
            allBoxList.add(copyList(boxList));
            return;
        }

        // 按不同规格的箱子分别装
        for (Box boxModel : boxModelList) {
            // 开启一个新箱子
            Box nowBox = new Box();
            nowBox.setVolume(boxModel.getVolume());
            nowBox.setOtherVolume(boxModel.getVolume());
            nowBox.setProductList(new ArrayList<>());
            boxList.add(nowBox);

            // 依次装箱，找出未装箱的产品
            List<Product> otherProductList = pushProduct(productList, nowBox);
            // 剩余产品找新箱子装
            allot(allBoxList, boxList, otherProductList);
            // 删除最后一个装入的箱子
            boxList.remove(boxList.size()-1);
        }
    }

    /**
     * 将产品最大程度放入指定容积的箱子中（动态规划算法）
     * @return 获取未装箱的产品
     */
    private List<Product> pushProduct(List<Product> productList, Box box) {
        // 箱子体积
        int w = box.getVolume();
        // 产品体积集合
        int[] v = new int[productList.size()];
        for (int i = 0; i < productList.size(); i++) {
            v[i] = productList.get(i).getVolume();
        }
        // 填表方式
        int[][] arr = new int[v.length+1][w+1];
        for (int i=1; i< arr.length; i++) {
            for (int j=1; j< arr[0].length; j++) {
                if (j < v[i-1]) {
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-v[i-1]] + v[i-1]);
                }
            }
        }

        // 表示存在最优的，找出已经装箱的产品
        List<Integer> useProductList = new ArrayList<>();
        if (arr[arr.length-1][arr[0].length-1] > 0) {
            int i = arr.length - 1;
            int j = arr[0].length - 1;
            while (i > 0 && j > 0) {
                if (j >= v[i-1] && arr[i][j] == arr[i-1][j-v[i-1]] + v[i-1]) {
                    // 当前是已选取的产品
                    useProductList.add(v[i-1]);
                    j = j - v[i-1];
                }
                i--;
            }
        }

        List<Product> otherProductList = new ArrayList<>();
        for (Product product: productList) {
            if (useProductList.contains(product.getVolume())) {
                // 移除已选取的产品
                Integer i = useProductList.stream().filter(p -> Objects.equals(p, product.getVolume())).findFirst().get();
                useProductList.remove(i);

                // 设置箱子剩余容量
                box.setOtherVolume(box.getOtherVolume() - product.getVolume());
                box.getProductList().add(product);
            } else {
                otherProductList.add(product);
            }
        }
        return otherProductList;
    }

    /**
     * 检查产品是否可以装入箱子，过滤出不能装箱的产品
     * @return
     */
    private void filterProduct() {
        List<Product> filterList = new ArrayList<>();
        for (Product product : productList) {
            // 任意一个箱子能装下的话，就可以装箱
            if (boxModelList.stream().anyMatch(box -> box.getVolume() >= product.getVolume())) {
                filterList.add(product);
            } else {
                System.out.println("产品太大，无法装箱：" + product);
            }
        }
        productList = filterList;
    }

    /**
     * 复制集合
     * @return
     */
    private List<Box> copyList(List<Box> boxList) {
        List<Box> returnList = new ArrayList<>();
        for (Box b : boxList) {
            Box bb = new Box();
            BeanUtils.copyProperties(b, bb);
            returnList.add(bb);
        }
        return returnList;
    }

    public static void main(String[] args) {
        // 箱子规格
        System.out.println("箱子：");
        List<Box> boxList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int volume = (int)(Math.random() * 10) + 10;
            Box b = new Box(volume);
            boxList.add(b);
            System.out.printf("%s ", volume);
        }
        System.out.println();

        // 产品集合
        System.out.println("产品：");
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int volume = (int)(Math.random() * 10) + 1;
            Product p = new Product((i+1), volume);
            productList.add(p);
            System.out.println(p);
        }

        BoxUtil boxAllot = new BoxUtil(boxList, productList);
        long startTime2 = System.currentTimeMillis();
        List<Box> returnList = boxAllot.getBox();
        long endTime2 = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime2 - startTime2) + "ms");
        for (int i = 0; i < returnList.size(); i++) {
            System.out.println("====推荐箱子[" + (i+1) + "]：" + returnList.get(i).getVolume());
            for(Product p : returnList.get(i).getProductList()) {
                System.out.println(p);
            }
        }
    }

}




