package com.zouls.design.pattern.creational.singleton.double_check;

/**
 * 封装执行任务的类
 */
public class Task implements Runnable {
    @Override
    public void run() {
        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + "  " + instance);
    }
}
