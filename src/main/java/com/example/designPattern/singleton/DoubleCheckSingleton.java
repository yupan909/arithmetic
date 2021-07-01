package com.example.designPattern.singleton;

/**
 * 单例模式 - 懒汉式（双重检查）
 *
 * @author yupan
 * @date 7/1/21 2:34 PM
 */
public class DoubleCheckSingleton {

    /**
     * 构造函数私有化
     */
    private DoubleCheckSingleton() {
    }

    /**
     * 这里用volatile修饰的作用禁止指令重排序优化：
     *
     *  因为instance = new Singleton()这行代码并不是一个原子指令，而是分为三个操作
     *    1、分配对象内存
     *    2、调用构造器方法，执行初始化
     *    3、将对象引用赋值给变量
     *  虚拟机实际运行时，以上指令可能发生重排序。以上代码2、3可能发生重排序，但是并不会重排1的顺序。
     *  也就是说1这个指令都需要先执行，因为2、3指令需要依托1指令执行结果。
     *
     *  如果线程1获取到锁进入创建对象实例，这个时候发生了指令重排序。
     *  当线程1执行t1和t3操作，线程2刚好进入，由于此时对象已经不为null，所以线程2可以自由访问该对象。
     *  然后该对象还未初始化，所以线程2访问时将会发生异常。
     */
    private static volatile DoubleCheckSingleton instance;

    /**
     * 双重校验锁
     */
    public static DoubleCheckSingleton getInstance() {
        // 第一个判空作用是只有不为空时才需要加锁，不加的话，每次都要加锁，影响效率
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                // 第二个判空作用是为了防止并发操作下有可能其他线程获取过锁，已经初始化过变量
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
