package com.example.designPattern.singleton;

/**
 * 单例模式 - 静态内部类
 *
 * @author yupan
 * @date 7/1/21 2:34 PM
 */
public class InnerClassSingleton {

    /**
     * 构造函数私有化
     */
    private InnerClassSingleton() {
    }

    /**
     * 定义一个私有静态内部类，利用静态内部类特点实现延迟加载，效率高
     */
    private static class SingletonInstance {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    /**
     * 提供一个公共的静态方法，返回实例对象
     */
    public static InnerClassSingleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
