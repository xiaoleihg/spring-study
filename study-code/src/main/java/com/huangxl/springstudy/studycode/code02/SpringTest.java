package com.huangxl.springstudy.studycode.code02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * bean名称和别名的生成规则演示
 * @author huangxl
 */
@Slf4j
public class SpringTest {
    public static void main(String[] args) {
        String path = "classpath:./spring-xml/02-beanAlias/bean-alias.xml";

        //创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        //getBeanDefinitionNames方法用于获取容器中所有的Bean名称
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            //根据bean名称获取bean别名,BeanFactory接口中定义的方法
            String[] aliases = context.getAliases(beanName);
            log.info("bean名称为:{},对应别名有:{}",beanName, Arrays.toString(aliases));
        }
        /** 运行结果如下
         * bean名称为:helloWorld,对应别名有:[]
         * bean名称为:student1,对应别名有:[]
         * bean名称为:student2,对应别名有:[]
         * bean名称为:student3,对应别名有:[student3-A]
         * bean名称为:student3-B,对应别名有:[]
         * bean名称为:student4,对应别名有:[student4-A, student4-B]
         * bean名称为:student5,对应别名有:[student5-C, student5-B, student5-A]
         * bean名称为:com.huangxl.springstudy.studycode.code02.Student#0,对应别名有:[com.huangxl.springstudy.studycode.code02.Student]
         * bean名称为:com.huangxl.springstudy.studycode.code02.Student#1,对应别名有:[]
         * bean名称为:java.lang.String#0,对应别名有:[java.lang.String]
         * bean名称为:java.lang.String#1,对应别名有:[]
         * bean名称为:student6,对应别名有:[student6-C, student6-B, student6-A]
         */

    }

}
