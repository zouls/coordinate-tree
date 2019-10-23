package com.zouls.coordinate_design_pattern.creational.singleton.double_check_singleton;

/**
 *
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
