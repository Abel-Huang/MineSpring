package cn.abelib.springframework.context.support;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.abelib.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/27 0:07
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        // Create a new XmlBeanDefinitionReader for the given BeanFactory.
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        loadBeanDefinitions(beanDefinitionReader);
    }

    /**
     * Load the bean definitions with the given XmlBeanDefinitionReader.
     */
    protected void loadBeanDefinitions(XmlBeanDefinitionReader reader) throws BeansException {
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            reader.loadBeanDefinitions(configLocations);
        }
    }
}
