package com.zouls.coordinate_design_pattern.creational.structural.decorator.v1;

/**
 * 这个写法有个问题
 * 就是鸡蛋和肠的组合太多了
 */
public class Test {
    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getDesc() + " 销售价格:" + battercake.cost());

        Battercake battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getDesc() + " 销售价格:" + battercakeWithEgg.cost());


        Battercake battercakeWithEggSausage = new BattercakeWithEggSausage();
        System.out.println(battercakeWithEggSausage.getDesc() + " 销售价格:" + battercakeWithEggSausage.cost());


    }
}
