package cn.abelib.springframework.aop.aspectj;

import cn.abelib.springframework.aop.Pointcut;
import cn.abelib.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/31 下午 10:38
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;

    private Advice advice;

    private String expression;

    public void setExpression(String expression){
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice){
        this.advice = advice;
    }
}
