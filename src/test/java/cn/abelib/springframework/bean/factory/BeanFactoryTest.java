package cn.abelib.springframework.bean.factory;

import cn.abelib.springframework.HelloService;
import cn.abelib.springframework.PropertyHelloDao;
import cn.abelib.springframework.PropertyHelloService;
import cn.abelib.springframework.beans.PropertyValue;
import cn.abelib.springframework.beans.PropertyValues;
import cn.abelib.springframework.beans.factory.support.AbstractBeanDefinition;
import cn.abelib.springframework.beans.factory.BeanReference;
import cn.abelib.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.abelib.springframework.beans.factory.support.RootBeanDefinition;
import org.junit.Test;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/10/25 23:17
 */
public class BeanFactoryTest {

    @Test
    public void testBeanFactory(){
        // 1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册bean
        AbstractBeanDefinition beanDefinition = new RootBeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        // 3.获取 bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService", "Abel");
        helloService.hello();
    }

    @Test
    public void testPropertyBeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. PropertyHelloDao 注册
        beanFactory.registerBeanDefinition("propertyHelloDao", new RootBeanDefinition(PropertyHelloDao.class));

        // 3. PropertyHelloService 设置属性[word、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "abel"));
        propertyValues.addPropertyValue(new PropertyValue("propertyHelloDao", new BeanReference("propertyHelloDao")));

        // 4. PropertyHelloService 注入bean
        AbstractBeanDefinition beanDefinition = new RootBeanDefinition(PropertyHelloService.class, propertyValues);
        beanFactory.registerBeanDefinition("propertyHelloService", beanDefinition);

        // 5. PropertyHelloService 获取bean
        PropertyHelloService propertyHelloService = (PropertyHelloService) beanFactory.getBean("propertyHelloService");
        propertyHelloService.hello();
    }
}
