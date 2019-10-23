package com.zouls.coordinate_design_pattern.creational.singleton.threadlocal;

/**
 * 不能保证全局唯一,但是能保证线程唯一
 * 多线程: 用空间换时间,会创建很多个对象,每个线程一个,每个线程之间不会影响
 */
public class ThreadLocalInstance {
    private static final ThreadLocal<ThreadLocalInstance> threadLocalInstanceThreadLocal
             = new ThreadLocal<ThreadLocalInstance>(){
        @Override
        protected ThreadLocalInstance initialValue() {
            return new ThreadLocalInstance();
        }
    };
    private ThreadLocalInstance(){

    }

    public static ThreadLocalInstance getInstance(){
        return threadLocalInstanceThreadLocal.get();
    }

}
