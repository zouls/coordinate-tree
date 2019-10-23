package com.zouls.coordinate_design_pattern.creational.singleton.hungry_singleton;

import com.zouls.coordinate_design_pattern.creational.singleton.lazy_singleton.LazySingleton;
import com.zouls.coordinate_design_pattern.creational.singleton.static_inner_class_singleton.StaticInnerClassSingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 这个类是一个综合的测试类
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // 测试序列化和反序列化对单例对象的破坏
//        HungrySingleton instance = HungrySingleton.getInstance();
//
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("singleton"));
//        outputStream.writeObject(instance);
//
//        File file = new File("singleton");
//        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
//        HungrySingleton newInstance = (HungrySingleton) inputStream.readObject();
//
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);


        // 测试通过反射破坏饿汉式单例对象
//        Class<HungrySingleton> singletonClass = HungrySingleton.class;
//        Constructor constructor = singletonClass.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        HungrySingleton newInstance = (HungrySingleton) constructor.newInstance();
//
//        HungrySingleton instance = HungrySingleton.getInstance();
//
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);

        // 测试通过反射破坏静态类实现的单例对象
//        Class<StaticInnerClassSingleton> singletonClass = StaticInnerClassSingleton.class;
//        Constructor constructor = singletonClass.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        StaticInnerClassSingleton newInstance = (StaticInnerClassSingleton) constructor.newInstance();
//
//        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
//
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);


        // 测试不是在类初始化的时候就创建好对象的单例模式
        Class<LazySingleton> singletonClass = LazySingleton.class;
        Constructor constructor = singletonClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazySingleton newInstance = (LazySingleton) constructor.newInstance();

        LazySingleton instance = LazySingleton.getInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }
}
