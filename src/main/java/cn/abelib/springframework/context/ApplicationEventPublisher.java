package cn.abelib.springframework.context;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/4 23:37
 */
public interface ApplicationEventPublisher {

    /**
     * Notify all matching listeners registered with this
     * application of an application event.
     */
    void publishEvent(ApplicationEvent event);
}
