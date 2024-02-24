package cn.abelib.springframework.core.io;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 23:23
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String path);

    ClassLoader getClassLoader();
}
