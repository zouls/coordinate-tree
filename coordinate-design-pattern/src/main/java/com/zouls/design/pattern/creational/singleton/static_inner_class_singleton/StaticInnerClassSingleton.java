package com.zouls.design.pattern.creational.singleton.static_inner_class_singleton;

/**
 * 基于静态内部类的单例设计模式实现
 */
public class StaticInnerClassSingleton {
    /**
     * 这个静态内部类需要时private的
     * 静态内部类初始化的时候有锁,这个锁只有一个线程能拿到,哪个线程拿到这个锁就去初始化这个内部类
     * 这个时候该线程初始化类的过程对于另外一个线程是不可见的(因为加了锁),所以这个时候即使发生了指令重排也无所谓
     */
    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    /**
     * 通过静态内部类获取对应的单例对象
     */
    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }

    /**
     * 这个构造方法里面抛异常是为了防御通过反射来构造多个单例对象
     * 但是这个只适用于在类加载的时候就已经初始化好了单例对象的模式
     */
    private StaticInnerClassSingleton() {
        if (InnerClass.staticInnerClassSingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

}
