package cn.abelib.springframework.event;

import cn.abelib.springframework.HelloMessage;
import cn.abelib.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/5 23:35
 */
public class ApplicationEventTest {

    @Test
    public void testEvent() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new HelloMessage(this.getClass().getSimpleName(), 1L, "Hello, World!"));

        applicationContext.registerShutdownHook();
    }
}
