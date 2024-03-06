package cn.abelib.springframework.context.event;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.BeanClassLoaderAware;
import cn.abelib.springframework.beans.factory.BeanFactory;
import cn.abelib.springframework.beans.factory.BeanFactoryAware;
import cn.abelib.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.abelib.springframework.context.ApplicationEvent;
import cn.abelib.springframework.context.ApplicationListener;
import cn.abelib.springframework.utils.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/2 19:10
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster,
        BeanClassLoaderAware, BeanFactoryAware {
    private ClassLoader beanClassLoader;

    private BeanFactory beanFactory;

    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        if (beanFactory instanceof ConfigurableBeanFactory) {
            ConfigurableBeanFactory cbf = (ConfigurableBeanFactory) beanFactory;
            if (this.beanClassLoader == null) {
                this.beanClassLoader = cbf.getBeanClassLoader();
            }
        }
    }

    private BeanFactory getBeanFactory() {
        if (this.beanFactory == null) {
            throw new IllegalStateException("ApplicationEventMulticaster cannot retrieve listener beans " +
                    "because it is not associated with a BeanFactory");
        }
        return this.beanFactory;
    }

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        this.applicationListeners.remove(listener);
        this.applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        this.applicationListeners.remove(listener);
    }

    @Override
    public void removeAllListeners() {
        this.applicationListeners.clear();
    }

    protected Collection<ApplicationListener<ApplicationEvent>> getApplicationListeners(ApplicationEvent event) {
        LinkedList<ApplicationListener<ApplicationEvent>> allListeners = new LinkedList<>();
        for (ApplicationListener<ApplicationEvent> listener : applicationListeners) {
            if (supportsEvent(listener, event)) {
                allListeners.add(listener);
            }
        }
        return allListeners;
    }

    /**
     * 监听器是否对该事件感兴趣
     * 参考： https://github.com/fuzhengwei/small-spring/blob/main/small-spring-step-11/src/main/java/cn/bugstack/springframework/context/event/AbstractApplicationEventMulticaster.java
     */
    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
        Class<? extends ApplicationListener> listenerClass = applicationListener.getClass();

        // 按照 CglibSubclassingInstantiationStrategy、SimpleInstantiationStrategy 不同的实例化类型，
        // 需要判断后获取目标 class
        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass)
                ? listenerClass.getSuperclass()
                : listenerClass;
        Type genericInterface = targetClass.getGenericInterfaces()[0];

        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }
        // 如果是A.isAssignableFrom(B) 确定一个类(B)是不是继承来自于另一个父类(A)，
        // 一个接口(A)是不是实现了另外一个接口(B)，或者两个类相同
        return eventClassName.isAssignableFrom(event.getClass());
    }
}
