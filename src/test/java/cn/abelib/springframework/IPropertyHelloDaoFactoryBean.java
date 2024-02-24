package cn.abelib.springframework;

import cn.abelib.springframework.beans.factory.FactoryBean;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/24 16:33
 */
public class IPropertyHelloDaoFactoryBean implements FactoryBean<PropertyHelloDao> {
    @Override
    public PropertyHelloDao getObject() throws Exception {
        return new PropertyHelloDao();
    }

    @Override
    public Class<?> getObjectType() {
        return PropertyHelloDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
