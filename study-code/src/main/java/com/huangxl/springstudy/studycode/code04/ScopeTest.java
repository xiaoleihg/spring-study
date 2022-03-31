package com.huangxl.springstudy.studycode.code04;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 * @author huangxl
 */
public class ScopeTest {

    ClassPathXmlApplicationContext context;

    /**
     * 这个@Before注解是junit的注解，会在所有的@Test方法执行之前执行该注解标注的方法
     *
     */
    @Before
    public void before(){
        System.out.println("spring容器准备启动.....");
        String path = "classpath:./spring-xml/04-scope/bean-scope.xml";

        //创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        this.context = new ClassPathXmlApplicationContext(path);
        System.out.println("spring容器启动完毕！");
    }

    @Test
    public void singletonTest(){
        System.out.println("---------单例bean---------");
        System.out.println(context.getBean("singletonScopeModel"));
        System.out.println(context.getBean("singletonScopeModel"));
        System.out.println(context.getBean("singletonScopeModel"));
    }

    @Test
    public void testPrototype(){
        System.out.println("---------prototype,原型bean---------");
        System.out.println(context.getBean("prototypeScopeModel"));
        System.out.println(context.getBean("prototypeScopeModel"));
        System.out.println(context.getBean("prototypeScopeModel"));
    }

    @Test
    public void testCustom(){
        /* 因为我在bean-scope.xml中注册了CustomScopeProcessor，就已经有了名为custom的作用域，所以直接通过before的方法启动就行了
         * 但是如果没有通过实现BeanFactoryPostProcessor并在xml配置的方式注册scope，就需要在手动创建容器的代码中注册scope
         * String path = "classpath:./spring-xml/04-scope/bean-scope.xml";
         * ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(){
         *      @Override
         *      protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
         *          { //向容器中注册自定义的scope
         *              beanFactory.registerScope("custom", new CustomScope());
         *              super.postProcessBeanFactory(beanFactory);
         *           }
         *  };
         * context.setConfigLocation(path);
         * //启动容器
         * context.refresh();
         */
        System.out.println("spring容器启动完毕！");
        for (int i = 0; i < 10; i++) {
            System.out.println("第"+(i+1)+"获取customScopeModel-->"+context.getBean("customScopeModel"));
        }
    }
}
