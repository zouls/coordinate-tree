package com.zouls.design.pattern.creational.singleton.enum_singleton;

/**
 * 基于枚举的单例设计模式实现
 */
public enum EnumInstance {
    INSTANCE {
        /**
         * 枚举里面也可以定义和使用方法,但是在外面必须定义一个抽象方法才能使用
         * 为什么呢?
         * 看反编译后的代码就知道了
         * 加了抽象方法之后其实这个枚举类就是一个抽象类
         * 然后这里写的这个方法就是抽象类的具体实现
         */
        protected void printTest() {
            System.out.println("Print Test");
        }
    };

    protected abstract void printTest();

    /**
     * 这个是要创建的单例对象,可以是其他类型,这里为了方便用的是Object类型
     */
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 返回该枚举单例的方法
     * 可以防止序列化和反序列化,怎么做到的?
     * 看{@link java.io.ObjectInputStream}
     * 2011行: 直接通过名字和类型创建的枚举 Enum.valueOf((Class)cl, name);
     * 这个valueOf方法其实会去枚举类中维护的一个map<String,T>中通过名字去找对应的实例
     * 名字是唯一的,然后这个枚举类也是唯一的,所以找到的实例对象肯定就是初始化的时候创建好的对象
     * 这个过程中不存在新的创建过程所以就不会被反射所影响
     * <p>
     * 可以防止反射创建: Cannot reflectively create enum objects
     */
    public static EnumInstance getInstance() {
        return INSTANCE;
    }

}
