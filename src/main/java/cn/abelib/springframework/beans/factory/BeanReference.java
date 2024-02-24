package cn.abelib.springframework.beans.factory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/11 23:23
 */
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
