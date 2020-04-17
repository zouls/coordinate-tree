package com.zouls.design.pattern.creational.singleton.double_check;

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
