package com.zouls.coordinate_design_pattern.structural.proxy.staticproxy;

import com.zouls.coordinate_design_pattern.structural.proxy.IOrderService;
import com.zouls.coordinate_design_pattern.structural.proxy.Order;
import com.zouls.coordinate_design_pattern.structural.proxy.OrderServiceImpl;
import com.zouls.coordinate_design_pattern.structural.proxy.db.DataSourceContextHolder;


public class OrderServiceStaticProxy {
    /**
     * 需要代理的对象
     */
    private IOrderService iOrderService;

    /**
     * 需要代理的方法
     */
    public int saveOrder(Order order) {
        beforeMethod(order);
        iOrderService = new OrderServiceImpl();
        int result = iOrderService.saveOrder(order);
        afterMethod();
        return result;
    }

    /**
     * 根据id的不同会插入到不同的db
     */
    private void beforeMethod(Order order) {
        int userId = order.getUserId();
        int dbRouter = userId % 2;
        System.out.println("静态代理分配到【db" + dbRouter + "】处理数据");

        // 设置dataSource
        DataSourceContextHolder.setDBType("db" + dbRouter);
        System.out.println("静态代理 before code");
    }

    private void afterMethod() {
        System.out.println("静态代理 after code");
    }
}
