package com.zouls.design.pattern.creational.singleton.enum_singleton;

public class Test {

    public static void main(String[] args) {

        // 测试序列化
//        EnumInstance instance = EnumInstance.getInstance();
//        instance.setData(new Object());
//
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("singleton"));
//        outputStream.writeObject(instance);
//
//        File file = new File("singleton");
//        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
//        EnumInstance newInstance = (EnumInstance) inputStream.readObject();
//
//        System.out.println(instance.getData());
//        System.out.println(newInstance.getData());
//        System.out.println(instance.getData() == newInstance.getData());

        // 结果
        // java.lang.Object@5fd0d5ae
        // java.lang.Object@5fd0d5ae
        // true

        // 测试反射
//        Class<EnumInstance> singletonClass = EnumInstance.class;
//        // Enum没有无参构造器
//        // 报错 java.lang.IllegalArgumentException: Cannot reflectively create enum objects
//        Constructor constructor = singletonClass.getDeclaredConstructor(String.class, int.class);
//        constructor.setAccessible(true);
//        EnumInstance newInstance = (EnumInstance) constructor.newInstance("test", 7);
//
//        EnumInstance instance = EnumInstance.getInstance();
//
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);

        EnumInstance.getInstance().printTest();

    }


}
