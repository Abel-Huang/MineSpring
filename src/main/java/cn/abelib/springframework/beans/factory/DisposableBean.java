package cn.abelib.springframework.beans.factory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/1/9 23:18
 */
public interface DisposableBean {

    /**
    * Invoked by a BeanFactory on destruction of a singleton.
    */
    void destroy() throws Exception;
}
