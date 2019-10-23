package com.zouls.coordinate_design_pattern.creational.singleton.lazy_singleton;

/**
 * 封装执行任务的类
 */
public class Task implements Runnable {
    @Override
    public void run() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + "  " + lazySingleton);
    }
}
