package cn.abelib.springframework.context.event;

import cn.abelib.springframework.context.ApplicationContext;
import cn.abelib.springframework.context.ApplicationEvent;

/**
 * Base class for events raised for an {@code ApplicationContext}.
 *
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/29 23:51
 */

public abstract class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Create a new ContextStartedEvent.
     */
    public ApplicationContextEvent(ApplicationContext source) {
        super(source);
    }

    /**
     * Get the ApplicationContext that the event was raised for.
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}