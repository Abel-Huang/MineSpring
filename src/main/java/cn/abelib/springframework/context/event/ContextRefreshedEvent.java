package cn.abelib.springframework.context.event;

import cn.abelib.springframework.context.ApplicationContext;

/**
 * Event raised when an ApplicationContext gets initialized or refreshed.
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/29 23:56
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * Create a new ContextStartedEvent.
     *
     * @param source
     */
    public ContextRefreshedEvent(ApplicationContext source) {
        super(source);
    }
}
