package com.example.designPattern.singleton;

/**
 * 《单例模式》
 *      所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，
 *  并且该类只提供一个取得其对象实例的方法(静态方法)。
 *
 *  实现单例模式的五种方式：
 *
 *     1)饿汉式
 *         优点：未加锁，执行效率高。
 *         缺点：类加载时就初始化实例，造成内存浪费。
 *
 *     2)懒汉式
 *         优点：在第一次调用才初始化，避免了内存浪费。
 *         缺点：对获取实例方法加锁，大大降低了并发效率。
 *
 *     3)双重检查
 *         即保证了懒加载，又保证了高性能，所以推荐使用。
 *
 *     4)静态内部类
 *         该模式利用了静态内部类延迟初始化的特性，来达到与双重检查方式一样的功能。由于需要借助辅助类，并不常用。
 *
 *     5)枚举
 *         该方式利用了枚举类的特性，不仅能避免线程同步问题，还防止反序列化重新创建新的对象。
 *         但由于这种编码方式还不能适应，所以实际工作中很少使用。
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
