package com.zouls.design.pattern.creational.structural.decorator.v1;

/**
 * 加鸡蛋和香肠的煎饼
 */
public class BattercakeWithEggSausage extends BattercakeWithEgg {
    @Override
    public String getDesc() {
        return super.getDesc() + " 加一根香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
