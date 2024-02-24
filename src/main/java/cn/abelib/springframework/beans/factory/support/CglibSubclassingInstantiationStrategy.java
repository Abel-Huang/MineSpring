package cn.abelib.springframework.beans.factory.support;

import cn.abelib.springframework.beans.BeansException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/11/1 23:43
 */
public class CglibSubclassingInstantiationStrategy extends SimpleInstantiationStrategy {

    @Override
    public Object instantiate(AbstractBeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object... args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
