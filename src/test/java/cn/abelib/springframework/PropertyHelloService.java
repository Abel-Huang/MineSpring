package cn.abelib.springframework;

import cn.abelib.springframework.beans.factory.DisposableBean;
import cn.abelib.springframework.beans.factory.InitializingBean;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 0:42
 */
public class PropertyHelloService implements IHelloService, InitializingBean, DisposableBean {

    private String name;

    private PropertyHelloDao propertyHelloDao;

    public String hello() {
        return this.name + " say: Hello, World!";
    }

    public void sayHello(){
        System.out.println("Say: " + propertyHelloDao.hello(name));
    }

    @Override
    public void destroy() throws Exception {
        System.err.println("----------destroy----------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("----------afterPropertiesSet----------");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertyHelloDao getPropertyHelloDao() {
        return propertyHelloDao;
    }

    public void setPropertyHelloDao(PropertyHelloDao propertyHelloDao) {
        this.propertyHelloDao = propertyHelloDao;
    }
}
