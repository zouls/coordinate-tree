package com.zouls.design.pattern.behavioral.strategy;

/**
 * 促销活动
 * <p>
 * 这个类整合了推销策略
 * 对外提供了统一的方法
 * 这个方法具体执行的是策略类的方法,这个类其实屏蔽了调用方对具体策略的认知
 * <p>
 * 执行的方法都是一样的,关键之处在与传入到这个类中的策略类还是要依据判断进行传入,这样才能执行具体的策略
 * <p>
 * 其实策略设计模式就是将调用方与具体的策略类分离开来
 * 不同策略都执行一个同名方法,具体执行哪个策略就看你传入什么策略类了
 */
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void executePromotionStrategy() {
        // 前后可以加逻辑
        promotionStrategy.doPromotion();
        // 前后可以加逻辑
    }

}
