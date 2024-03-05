package cn.abelib.springframework.context.event;

import cn.abelib.springframework.beans.factory.BeanFactory;
import cn.abelib.springframework.context.ApplicationEvent;
import cn.abelib.springframework.context.ApplicationListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/3 22:25
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    /**
     * Create a new SimpleApplicationEventMulticaster.
     */
    public SimpleApplicationEventMulticaster() {
    }

    /**
     * Create a new SimpleApplicationEventMulticaster for the given BeanFactory.
     */
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener<ApplicationEvent> listener : getApplicationListeners(event)) {
            try {
                listener.onApplicationEvent(event);
            } catch (ClassCastException ex) {
                String msg = ex.getMessage();
                if (msg == null || msg.startsWith(event.getClass().getName())) {
                    // Possibly a lambda-defined listener which we could not resolve the generic event type for
                    Log logger = LogFactory.getLog(getClass());
                    if (logger.isDebugEnabled()) {
                        logger.debug("Non-matching event type for listener: " + listener, ex);
                    }
                } else {
                    throw ex;
                }
            }
        }
    }
}
