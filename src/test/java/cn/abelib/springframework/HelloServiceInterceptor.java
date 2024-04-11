package cn.abelib.springframework;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/26 22:55
 */
public class HelloServiceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            System.out.println("AOP start");
            System.out.println("Method Name:" + invocation.getMethod());
            System.out.println("Spent Time:" + (System.currentTimeMillis() - start) + "ms");
            System.out.println("AOP end\r\n");
        }
    }
}

