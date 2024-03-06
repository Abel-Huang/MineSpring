package cn.abelib.springframework.context.event;

import cn.abelib.springframework.context.ApplicationContext;

/**
 * Event raised when an ApplicationContext gets stopped.
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/29 23:56
 */
public class ContextStoppedEvent extends ApplicationContextEvent {

    /**
     * Create a new ContextStartedEvent.
     *
     * @param source
     */
    public ContextStoppedEvent(ApplicationContext source) {
        super(source);
    }
}
