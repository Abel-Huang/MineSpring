package cn.abelib.springframework;

import cn.abelib.springframework.context.ApplicationEvent;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/5 23:24
 */
public class HelloMessage extends ApplicationEvent {
    private Long id;

    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source
     */
    public HelloMessage(Object source, Long id, String msg) {
        super(source);
        this.id = id;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
