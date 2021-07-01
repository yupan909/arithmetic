package com.example.designPattern.singleton;

/**
 * 单例模式 - 测试
 *
 * @author yupan
 * @date 7/1/21 2:46 PM
 */
public class SingletonTest {

    public static void main(String[] args) {
        // 饿汉式
        HungerSingleton hungerSingleton1 = HungerSingleton.getInstance();
        HungerSingleton hungerSingleton2 = HungerSingleton.getInstance();
        System.out.println("饿汉式：" + (hungerSingleton1 == hungerSingleton2));

        // 懒汉式
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println("懒汉式：" + (lazySingleton1 == lazySingleton2));

        // 双重检查
        DoubleCheckSingleton doubleCheckSingleton1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton doubleCheckSingleton2 = DoubleCheckSingleton.getInstance();
        System.out.println("双重检查：" + (doubleCheckSingleton1 == doubleCheckSingleton2));

        // 静态内部类
        InnerClassSingleton innerClassSingleton1 = InnerClassSingleton.getInstance();
        InnerClassSingleton innerClassSingleton2 = InnerClassSingleton.getInstance();
        System.out.println("静态内部类：" + (innerClassSingleton1 == innerClassSingleton2));

        // 枚举
        EnumSingleton enumSingleton1= EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2= EnumSingleton.INSTANCE;
        System.out.println("枚举：" + (enumSingleton1 == enumSingleton2));
    }
}
