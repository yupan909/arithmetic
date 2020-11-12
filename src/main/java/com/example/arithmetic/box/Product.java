package com.example.arithmetic.box;

/**
 * 产品
 *
 * @author yupan
 * @date 2020-11-06 11:19
 */
public class Product {

    /**
     * 编号
     */
    private Integer id;

    /**
     * 产品体积
     */
    private Integer volume;

    public Product() {
    }

    public Product(Integer id, Integer volume) {
        this.id = id;
        this.volume = volume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", volume=" + volume + '}';
    }
}
