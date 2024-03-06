package cn.abelib.springframework;

import cn.abelib.springframework.context.ApplicationListener;
import java.time.LocalDateTime;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/5 23:26
 */
public class HelloEventListener implements ApplicationListener<HelloMessage> {

    @Override
    public void onApplicationEvent(HelloMessage event) {
        System.out.println("receive: " + event.getSource() + " msg");
        System.out.println("date: " + LocalDateTime.now());
        System.out.println("id: " + event.getId());
        System.out.println("msg: " + event.getMsg());
    }
}
