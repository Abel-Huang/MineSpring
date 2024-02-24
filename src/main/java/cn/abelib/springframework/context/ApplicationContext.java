package cn.abelib.springframework.context;

import cn.abelib.springframework.beans.factory.HierarchicalBeanFactory;
import cn.abelib.springframework.beans.factory.ListableBeanFactory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/27 0:03
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory {
}
