package com.huangxl.springstudy.studycode.code03;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * spring容器创建bean实例对象的4种方式
 * 1. 通过反射调用构造方法创建bean对象
 * 2. 通过静态工厂方法创建bean对象
 * 3. 通过实例工厂方法创建bean对象
 * 4. 通过FactoryBean创建bean对象
 * @author huangxl
 */
@Slf4j
public class SpringTest {

    /**
     * 通过反射调用构造方法创建bean对象,
     * 另外，通过StudentEntity的构造方法中的打印内容可知：
     * 构造方法是在容器启动过程中调用的，说明这个bean实例在容器启动过程中就创建好了，放在容器中缓存着
     */
    @Test
    public void testConstructor() {
        String path = "classpath:./spring-xml/03-beanCreate/bean-constructor.xml";

        //创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);

        //getBeanDefinitionNames方法用于获取容器中所有的Bean名称
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("spring容器中的bean如下:");
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName+"->"+context.getBean(beanName));
        }
    }
    /**
     * 通过静态工厂方法创建bean对象
     */
    @Test
    public void testStaticFactory() {
        String path = "classpath:./spring-xml/03-beanCreate/bean-staticFactory.xml";

        //创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);

        //getBeanDefinitionNames方法用于获取容器中所有的Bean名称
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("spring容器中的bean如下:");
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName+"->"+context.getBean(beanName));
        }
    }

    /**
     * 通过实例工厂方法创建bean对象，
     * 说白了就是spring想创建一个工厂的实例，在通过这个工厂实例的方法去创建我们想要的实例对象
     */
    @Test
    public void testInstanceFactory() {
        String path = "classpath:./spring-xml/03-beanCreate/bean-instanceFactory.xml";

        //创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);

        //getBeanDefinitionNames方法用于获取容器中所有的Bean名称
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("spring容器中的bean如下:");
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName+"->"+context.getBean(beanName));
        }
    }

    /**
     * 通过FactoryBean创建bean对象,即实现FactoryBean接口
     * 我们在xml里面配置的是实现类的bean，但是获取到的bean对象是getObject的对象，
     * 简单来说，spring容器getBean的时候会判断是不是FactoryBean，是的话会调用getObject方法得到bean实例
     */
    @Test
    public void testFactoryBean(){
        String path = "classpath:./spring-xml/03-beanCreate/bean-factoryBean.xml";

        //创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);

        //getBeanDefinitionNames方法用于获取容器中所有的Bean名称
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName+"->"+context.getBean(beanName));
        }

        // 将ScoreFactoryBean的isSingleton方法默认返回false后
        System.out.println("-------------------------------");
        System.out.println("多次获取bean");
        System.out.println("createByFactoryBean:" + context.getBean("scoreFactoryBean"));
        System.out.println("createByFactoryBean:" + context.getBean("scoreFactoryBean"));

    }
}
