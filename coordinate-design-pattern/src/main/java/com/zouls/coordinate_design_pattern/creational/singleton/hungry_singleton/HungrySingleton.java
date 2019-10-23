package com.zouls.coordinate_design_pattern.creational.singleton.hungry_singleton;

import java.io.Serializable;

/**
 * 基于饿汉式的单例设计模式实现
 * 如果这个类从始至终都没有用过就可能会造成内存的浪费
 *
 * 需要实现序列化接口,不然会报错
 */
public class HungrySingleton implements Serializable, Cloneable {

    /**
     * 在类加载的时候就做成final的,不可变,之后不可改
     */
    private final static HungrySingleton hungrySingleton;

    // 在类加载的时候就完成初始化
    static {
        hungrySingleton = new HungrySingleton();
    }

    /**
     * 这个构造方法里面抛异常是为了防御通过反射来构造多个单例对象
     * 但是这个只适用于在类加载的时候就已经初始化好了单例对象的模式
     */
    private HungrySingleton() {
        if (hungrySingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    /**
     * 解决序列化和反序列化的问题
     * 这个方法是反射的,没什么继承关系,反射的时候只要发现有这个方法调用就行
     *
     * 重点看 {@link java.io.ObjectInputStream}
     * 2053行: 可以看出如果有序列化的接口就是用反射创建
     * 2076行: 如果有序列化接口同时有readResolve方法的话,就调用该方法,如果没有的话就直接返回反射创建的对象了
     *
     * {@link java.io.ObjectStreamClass}
     * 534行: 为什么是这个名字,因为源码里面就是写的字符串指定的这个名字
     *
     * 这个过程中其实已经用反射实例化了一个对象,只不过最终没有使用而已
     */
    private Object readResolve() {
        return hungrySingleton;
    }
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return getInstance();
//    }
}
