package com.zouls.coordinate_design_pattern.behavioral.chainofresponsibility;

/**
 * 批准者
 */
public abstract class Approver {
    /**
     * protected 子类和同包可以访问, 让子类可以获取到该成员变量
     *
     * 类中包含自己类型的对象
     *
     * 这里也可以起名为handler
     */
    protected Approver approver;

    /**
     * 设置下一个批准者
     * @param approver
     */
    public void setNextApprover(Approver approver) {
        this.approver = approver;
    }

    /**
     * 发布课程, 交给子类实现
     * @param course
     */
    public abstract void deploy(Course course);
}