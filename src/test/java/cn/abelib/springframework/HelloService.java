package cn.abelib.springframework;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.BeanClassLoaderAware;
import cn.abelib.springframework.beans.factory.BeanFactory;
import cn.abelib.springframework.beans.factory.BeanFactoryAware;
import cn.abelib.springframework.beans.factory.BeanNameAware;
import cn.abelib.springframework.context.ApplicationContext;
import cn.abelib.springframework.context.ApplicationContextAware;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/10/25 23:16
 */
public class HelloService implements IHelloService, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private String name;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public HelloService(){}

    public HelloService(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println(this.name + " Hello, World!");
    }

    public String hello(){
        return this.name + " Hello, World!";
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
        System.out.println("setBeanName");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("setApplicationContext");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}