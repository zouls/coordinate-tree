package com.zouls.coordinate_design_pattern.creational.singleton.double_check_singleton;

/**
 * 基于双重锁的单例的实现
 */
public class LazyDoubleCheckSingleton {

    /**
     * volatile禁止指令重排
     */
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    /**
     * 私有化构造方法
     */
    private LazyDoubleCheckSingleton() {

    }

    /**
     * 其实所谓的双重锁就是判断两次
     * 因为判断是否有对象这个操作是没有必要在获取锁的情况下进行,如果有单例对象就直接返回好了,没有必要获取锁
     * 如果没有单例对象再去尝试获取锁,这样才是正确的逻辑
     * <p>
     * 需要注意的一点是:
     * 这个单例对象必须用volatile关键字进行修饰
     * 因为new对象这个操作在jvm中是三个指令
     * 1.分配内存给这个对象
     * 3.设置变量指向刚分配的内存地址
     * 2.初始化对象
     * <p>
     * 如果是像上面的这种指令的顺序的话就会出现问题
     * 先向变量分配了内存的地址,意味着这个时候该变量就不为null了,但是这个时候还没有进行实际对象的初始化
     * 另一个线程这个时候如果来访问的话,就会报错,因为对象还没有进行初始化
     * <p>
     * 如果加了volatile关键字就可以解决这个问题,因为volatile这可以禁止指令重排,也就是必然按照1->2->3的顺序执行,不会出现问题
     * 详细过程看readme图示
     */
    public static LazyDoubleCheckSingleton getInstance() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null) {
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    //1.分配内存给这个对象
//                  //3.设置lazyDoubleCheckSingleton 指向刚分配的内存地址
                    //2.初始化对象
//                    intra-thread semantics:就是说在单个线程中重排指令不会影响结果,但是不能保证在多个线程中也是这样
//                    ---------------//3.设置lazyDoubleCheckSingleton 指向刚分配的内存地址
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
