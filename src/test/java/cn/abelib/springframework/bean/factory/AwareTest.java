package cn.abelib.springframework.bean.factory;

import cn.abelib.springframework.HelloService;
import cn.abelib.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/5 0:06
 */
public class AwareTest {
    @Test
    public void testAware(){
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 获取Bean对象调用方法
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);
        String result = helloService.hello();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware：" + helloService.getApplicationContext());
        System.out.println("BeanFactoryAware：" + helloService.getBeanFactory());
    }
}
