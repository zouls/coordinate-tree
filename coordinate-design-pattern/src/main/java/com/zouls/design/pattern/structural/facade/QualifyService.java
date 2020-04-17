package com.zouls.design.pattern.structural.facade;

/**
 * 资格认证的子系统
 */
public class QualifyService {
    /**
     * 校验是否有资格兑换礼物
     *
     * @param pointsGift
     * @return
     */
    public boolean isAvailable(PointsGift pointsGift) {
        System.out.println("校验" + pointsGift.getName() + " 积分资格通过,库存通过");
        return true;
    }
}
