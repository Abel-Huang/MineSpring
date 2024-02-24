package cn.abelib.springframework.beans.factory.support;

import cn.abelib.springframework.beans.factory.DisposableBean;
import cn.abelib.springframework.beans.factory.config.SingletonBeanRegistry;
import cn.abelib.springframework.utils.StringUtils;

import java.util.*;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/10/26 0:38
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * Internal marker for a null singleton object:
     * used as marker value for concurrent Maps (which don't support null values).
     */
    protected static final Object NULL_OBJECT = new Object();

    private Map<String, Object> singletonObjects = new HashMap<>();

    /** Disposable bean instances: bean name --> disposable instance */
    private final Map<String, Object> disposableBeans = new LinkedHashMap<String, Object>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    /**
     * Add the given bean to the list of disposable beans in this registry.
     */
    public void registerDisposableBean(String beanName, DisposableBean bean) {
        synchronized (this.disposableBeans) {
            this.disposableBeans.put(beanName, bean);
        }
    }

    public void destroySingletons() {
        String[] disposableBeanNames;
        synchronized (this.disposableBeans) {
            disposableBeanNames = StringUtils.toStringArray(this.disposableBeans.keySet());
        }
        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            destroySingleton(disposableBeanNames[i]);
        }

        synchronized (this.singletonObjects) {
            this.singletonObjects.clear();
        }
    }

    /**
     * Destroy the given bean. Delegates to {@code destroyBean}
     */
    public void destroySingleton(String beanName) {
        // Remove a registered singleton of the given name, if any.
        removeSingleton(beanName);

        // Destroy the corresponding DisposableBean instance.
        DisposableBean disposableBean;
        synchronized (this.disposableBeans) {
            disposableBean = (DisposableBean) this.disposableBeans.remove(beanName);
        }
        destroyBean(beanName, disposableBean);
    }

    /**
     * Remove the bean with the given name from the singleton cache of this factory,
     * to be able to clean up eager registration of a singleton if creation failed.
     */
    protected void removeSingleton(String beanName) {
        synchronized (this.singletonObjects) {
            this.singletonObjects.remove(beanName);
        }
    }

    /**
     * TODO 未考虑依赖之间的关系
     * Destroy the given bean. Must destroy beans that depend on the given
     * bean before the bean itself. Should not throw any exceptions.
     */
    protected void destroyBean(String beanName, DisposableBean bean) {
        // Actually destroy the bean now...
        if (bean != null) {
            try {
                bean.destroy();
            }
            catch (Throwable ex) {
                System.out.println("Destroy method on bean with name '" + beanName + "' threw an exception" + ex.getLocalizedMessage());
            }
        }
    }
}
