package com.example.designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 形状工厂类
 *
 * @author yupan
 * @date 7/11/21 4:15 PM
 */
public class ShapeFactory {

    private Map<String, Shape> shapeMap = new HashMap<>();

    /**
     * 获取形状类对象
     * @return
     */
    public Shape getShape(String type) {
        if (!shapeMap.containsKey(type)) {
            shapeMap.put(type, new ShapeImpl(type));
        }
        return shapeMap.get(type);
    }

    /**
     * 获取对象个数
     * @return
     */
    public Integer size() {
        return shapeMap.size();
    }

}
