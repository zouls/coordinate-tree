package com.zouls.coordinate_design_pattern.creational.singleton.lazy_singleton;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t1.start();
        t2.start();
        System.out.println("program end");
    }
}
