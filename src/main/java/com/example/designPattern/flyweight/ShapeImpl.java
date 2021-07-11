package com.example.designPattern.flyweight;

/**
 * 形状类
 *
 * @author yupan
 * @date 7/11/21 4:12 PM
 */
public class ShapeImpl implements Shape {

    /**
     * 内部享元部分
     */
    private String type;

    public ShapeImpl(String type) {
        this.type = type;
    }

    /**
     * 外部享元角色(Color)
     */
    @Override
    public void show(Color color) {
        System.out.println("绘制出：" + type + "，颜色为：" + color.getName());
    }
}
