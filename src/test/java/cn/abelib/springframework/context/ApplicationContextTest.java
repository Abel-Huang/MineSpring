package cn.abelib.springframework.context;

import cn.abelib.springframework.PropertyHelloService;
import cn.abelib.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/1/25 0:01
 */
public class ApplicationContextTest {

    @Test
    public void testClassPathXmlApplicationContext() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        PropertyHelloService propertyHelloService = applicationContext.getBean("propertyHelloService", PropertyHelloService.class);
        String result = propertyHelloService.hello();
        System.out.println("result:" + result);
    }

    @Test
    public void testFactoryBean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        PropertyHelloService propertyHelloService = applicationContext.getBean("propertyHelloService", PropertyHelloService.class);
        String result = propertyHelloService.hello();
        System.out.println("result:" + result);
    }
}
