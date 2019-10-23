package com.zouls.coordinate_design_pattern.creational.singleton.lazy_singleton;

/**
 * 使用最简单的同步锁实现的,没什么问题,但是效率低,基于同步方法
 * 一个线程获取到锁之后,后面的线程都等着
 * 而且判断的逻辑 `if (lazySingleton == null) {` 也是在同步代码块里面,没有什么必要
 * 如果没有单例对象就直接返回就好了,没必要获取锁再进行判断
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
        if (lazySingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public synchronized static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }


}
