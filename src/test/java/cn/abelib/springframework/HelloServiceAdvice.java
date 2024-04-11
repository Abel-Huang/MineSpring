package cn.abelib.springframework;

import cn.abelib.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/4/8 下午 11:13
 */
public class HelloServiceAdvice implements MethodBeforeAdvice {
    public HelloServiceAdvice() {}

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Intercept method name: " + method.getName());
    }
}
