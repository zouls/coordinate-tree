package com.zouls.design.pattern.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 这种工厂方法确实可以不用写if...else...
 * 但是确实也是只适合于策略类的实现
 * 怎么说呢,就是说这个类一旦new出来之后便不会修改,只是执行其中的方法
 * 但是如果有些场景中需要改变map中new出来的对象的话就不行了
 * 简单的说就是只能适用于无状态的情景中,有状态的情况还是得单独每次new一个新的类,还是要写if else
 */
public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.LIJIAN, new LiJianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.MANJIAN, new ManJianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.FANXIAN, new FanXianPromotionStrategy());
    }

    private PromotionStrategyFactory() {

    }

    private static final PromotionStrategy NON_PROMOTION = new EmptyPromotionStrategy();

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionKey == null ? NON_PROMOTION : promotionStrategy;
    }

    private interface PromotionKey {
        String LIJIAN = "LIJIAN";
        String FANXIAN = "FANXIAN";
        String MANJIAN = "MANJIAN";
    }
}