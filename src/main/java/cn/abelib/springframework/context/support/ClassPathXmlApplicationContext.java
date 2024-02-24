package cn.abelib.springframework.context.support;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.BeanFactory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/27 0:08
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    /**
     * Create a new ClassPathXmlApplicationContext for bean-style configuration.
     */
    public ClassPathXmlApplicationContext() {
    }

    /**
     * Create a new ClassPathXmlApplicationContext, loading the definitions
     */
    public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[] {configLocation}, true);
    }


    public ClassPathXmlApplicationContext(String[] configLocations, boolean refresh) {
        setConfigLocations(configLocations);
        if (refresh) {
            refresh();
        }
    }

    @Override
    public BeanFactory getParentBeanFactory() {
        return null;
    }
}