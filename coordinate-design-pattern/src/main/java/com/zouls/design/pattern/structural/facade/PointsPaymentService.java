package com.zouls.design.pattern.structural.facade;

/**
 * 用积分支付购买物品的子系统
 */
public class PointsPaymentService {
    /**
     * 积分是否扣减成功
     */
    public boolean pay(PointsGift pointsGift) {
        //扣减积分
        System.out.println("支付" + pointsGift.getName() + " 积分成功");
        return true;
    }

}
