package cn.abelib.springframework.aop;

import cn.abelib.springframework.HelloService;
import cn.abelib.springframework.HelloServiceInterceptor;
import cn.abelib.springframework.IHelloService;
import cn.abelib.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.abelib.springframework.aop.framework.AdvisedSupport;
import cn.abelib.springframework.aop.framework.CglibAopProxy;
import cn.abelib.springframework.aop.framework.JdkDynamicAopProxy;
import org.junit.Test;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/26 22:59
 */
public class AopTest {

    @Test
    public void testDynamicAop() {
        // 目标对象
        HelloService helloService = new HelloService("Abel");

        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(helloService));
        advisedSupport.setMethodInterceptor(new HelloServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.abelib.springframework.IHelloService.*(..))"));

        // JdkDynamicAopProxy
        IHelloService jdkProxy = (IHelloService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("jdkProxy result: " + jdkProxy.hello());

        // Cglib2AopProxy
        IHelloService cglibProxy = (IHelloService) new CglibAopProxy(advisedSupport).getProxy();
        cglibProxy.sayHello();
    }
}
