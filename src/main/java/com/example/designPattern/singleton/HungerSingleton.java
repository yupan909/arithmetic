package com.example.designPattern.singleton;

/**
 * 单例模式 - 饿汉式
 *
 * @author yupan
 * @date 7/1/21 2:34 PM
 */
public class HungerSingleton {

    /**
     * 构造函数私有化
     */
    private HungerSingleton() {
    }

    /**
     * 定义对象时直接创建实例
     */
    private static final HungerSingleton instance = new HungerSingleton();

    /**
     * 提供一个公共的静态方法，返回实例对象
     */
    public static HungerSingleton getInstance() {
        return instance;
    }
}
