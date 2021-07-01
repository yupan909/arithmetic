package com.example.designPattern.singleton;

/**
 * 单例模式 - 懒汉式
 *
 * @author yupan
 * @date 7/1/21 2:34 PM
 */
public class LazySingleton {

    /**
     * 构造函数私有化
     */
    private LazySingleton() {
    }

    /**
     * 定义对象
     */
    private static LazySingleton instance;

    /**
     * 提供一个公共的静态方法，当使用时才会去创建实例，该方法使用synchronized加锁，来保证线程安全性
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
