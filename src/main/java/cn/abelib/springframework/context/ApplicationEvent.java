package cn.abelib.springframework.context;

import java.util.EventObject;

/**
 * Class to be extended by all application events. Abstract as it
 * doesn't make sense for generic events to be published directly.
 *
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/29 23:50
 */
public abstract class ApplicationEvent extends EventObject {

    /** System time when the event happened */
    private final long timestamp;


    /**
     * Create a new ApplicationEvent.
     */
    public ApplicationEvent(Object source) {
        super(source);
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * Return the system time in milliseconds when the event happened.
     */
    public final long getTimestamp() {
        return this.timestamp;
    }
}