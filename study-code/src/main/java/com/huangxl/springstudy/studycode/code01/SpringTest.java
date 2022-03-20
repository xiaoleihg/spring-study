package com.huangxl.springstudy.studycode.code01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huangxl
 */
public class SpringTest {
    public static void main(String[] args) {
        //1.bean配置文件位置
        String beanXml = "classpath:./spring-xml/01-start/bean-helloworld.xml";

        //2.创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        //3.从容器中获取需要的bean
        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);

        //4.使用对象
        helloWorld.say();
    }
}
