package com.zouls.design.pattern.behavioral.strategy;

public class Test {
//    public static void main(String[] args) {
//        PromotionActivity promotionActivity618 = new PromotionActivity(new LiJianPromotionStrategy());
//        PromotionActivity promotionActivity1111 = new PromotionActivity(new FanXianPromotionStrategy());
//
//        promotionActivity618.executePromotionStrategy();
//        promotionActivity1111.executePromotionStrategy();
//    }

    public static void main(String[] args) {
        String key = "LIJIAN";
        PromotionActivity promotionActivity618 = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(key));
        promotionActivity618.executePromotionStrategy();

        System.out.println();
    }
}
