package com.zouls.design.pattern.structural.facade;

/**
 * 物流子系统
 */
public class ShippingService {
    /**
     * 返回物流系统通过的订单号
     */
    public String shipGift(PointsGift pointsGift) {
        //物流系统的对接逻辑
        System.out.println(pointsGift.getName() + "进入物流系统");
        String shippingOrderNo = "666";
        return shippingOrderNo;
    }
}
