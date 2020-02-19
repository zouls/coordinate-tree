package com.zouls.coordinate_design_pattern.structural.proxy.dynamicproxy;

import com.zouls.coordinate_design_pattern.structural.proxy.Order;
import com.zouls.coordinate_design_pattern.structural.proxy.db.DataSourceContextHolder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by geely
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    /**
     * 需要代理的对象
     */
    private Object target;

    /**
     * 通过构造方法将需要代理的目标对象传进来
     */
    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 创建动态代理类
     */
    public Object bind() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object argObject = args[0];
        beforeMethod(argObject);
        Object object = method.invoke(target, args);
        afterMethod();
        return object;
    }

    private void beforeMethod(Object obj) {
        int userId = 0;
        System.out.println("动态代理 before code");
        if (obj instanceof Order) {
            Order order = (Order) obj;
            userId = order.getUserId();
        }
        int dbRouter = userId % 2;
        System.out.println("动态代理分配到【db" + dbRouter + "】处理数据");

        // 设置dataSource
        DataSourceContextHolder.setDBType("db" + dbRouter);
    }

    private void afterMethod() {
        System.out.println("动态代理 after code");
    }
}
