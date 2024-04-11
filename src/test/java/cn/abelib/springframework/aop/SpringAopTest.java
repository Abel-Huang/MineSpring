package cn.abelib.springframework.aop;

import cn.abelib.springframework.HelloAopService;
import cn.abelib.springframework.IHelloService;
import cn.abelib.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/4/8 下午 11:22
 */
public class SpringAopTest {

    @Test
    public void testAop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_aop.xml");
        IHelloService helloService = applicationContext.getBean("helloService", HelloAopService.class);

        System.out.println("result: " + helloService.hello());
    }
}
