package cn.abelib.springframework.context.event;

import cn.abelib.springframework.context.ApplicationEvent;
import cn.abelib.springframework.context.ApplicationListener;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/2 18:56
 */
public interface ApplicationEventMulticaster {
    /**
     * Add a listener to be notified of all events.
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove all listeners registered with this multicaster.
     */
    void removeAllListeners();

    /**
     * Multicast the given application event to appropriate listeners.
     */
    void multicastEvent(ApplicationEvent event);
}
