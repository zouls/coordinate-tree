package com.zouls.coordinate_design_pattern.creational.singleton.container_singleton;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基于容器创建
 * 可以通过map的特性管理一组单例对象
 */
public class ContainerSingleton {

    private ContainerSingleton(){

    }

    /**
     * 这里用hashMap不是线程安全的
     * 用concurrentHashMap也不是绝对线程安全的
     */
    private static Map<String,Object> singletonMap = new ConcurrentHashMap<String, Object>();

    public static void putInstance(String key,Object instance){
        // key不为空,实例也不为空
        if(StringUtils.isNotBlank(key) && instance != null){
            // 容器中没有的情况下才放入
            if(!singletonMap.containsKey(key)){
                singletonMap.put(key,instance);
            }
        }
    }

    public static Object getInstance(String key){
        return singletonMap.get(key);
    }


}
