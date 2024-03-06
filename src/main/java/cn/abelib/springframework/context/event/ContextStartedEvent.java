package cn.abelib.springframework.context.event;

import cn.abelib.springframework.context.ApplicationContext;

/**
 * Event raised when an ApplicationContext gets started.
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/29 23:56
 */
public class ContextStartedEvent extends ApplicationContextEvent {
    /**
     * Create a new ContextStartedEvent.
     *
     * @param source
     */
    public ContextStartedEvent(ApplicationContext source) {
        super(source);
    }
}
