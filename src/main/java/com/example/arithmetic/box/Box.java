package com.example.arithmetic.box;


import java.util.List;

/**
 * 箱子
 *
 * @author yupan
 * @date 2020-11-06 11:18
 */
public class Box {

    /**
     * 箱子体积
     */
    private Integer volume;

    /**
     * 剩余体积
     */
    private Integer otherVolume;

    /**
     * 装箱产品
     */
    private List<Product> productList;

    public Box() {

    }

    public Box(Integer volume) {
        this.volume = volume;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getOtherVolume() {
        return otherVolume;
    }

    public void setOtherVolume(Integer otherVolume) {
        this.otherVolume = otherVolume;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
