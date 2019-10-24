package com.zouls.coordinate_design_pattern.creational.structural.decorator.v1;

/**
 * 煎饼
 */
public class Battercake {
    /**
     * 方法只在子类中重写,所以用protected
     */
    protected String getDesc() {
        return "煎饼";
    }

    protected int cost() {
        // 煎饼8块钱
        return 8;
    }

}
