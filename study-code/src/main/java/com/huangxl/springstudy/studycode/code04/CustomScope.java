package com.huangxl.springstudy.studycode.code04;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义scope，通过实现Scope接口来自定义。
 * 这里我的设计是，每三次获取bean对象的时候创建一个新的对象
 * 仅用作展示自定义作用域的方法，无实际业务意义，网上有线程作用域的代码，也可以参考那个
 * @author huangxl
 */
public class CustomScope implements Scope {
    /**
     * AtomicInteger--原子操作类，线程安全
     * 用于计算bean实例对象生成次数
     */
    private static AtomicInteger count = new AtomicInteger(0);

    /**
     * ConcurrentHashMap,看做一个线程安全的HashMap就行了，需要的同学自行学习。
     * 这里用来作为缓存，存储生成的Bean实例对象
     */
    private static ConcurrentHashMap<String,Object> cache = new ConcurrentHashMap<>(64);


    /**
     *
     * @param s beanName,即bean的名称
     * @param objectFactory 通过该工厂可以生成bean实例
     * @return bean 需要获取的bean实例
     */
    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        Object bean = null;
        int num = count.getAndIncrement();
        if (num % 3 == 0){
            bean = objectFactory.getObject();
            cache.put(s,bean);
        }else{
            bean = cache.get(s);
        }
        return bean;
    }

    @Override
    public Object remove(String s) {
        cache.remove(s);
        return cache;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {
        //bean作用域范围结束的时候调用的方法，用于bean清理
        System.out.println(s);
    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
