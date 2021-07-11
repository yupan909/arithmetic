package com.example.designPattern.flyweight;

/**
 * 颜色
 *
 * @author yupan
 * @date 7/11/21 4:09 PM
 */
public class Color {

    private String name;

    public Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
